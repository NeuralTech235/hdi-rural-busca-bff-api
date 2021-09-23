package com.hdi.ruralbuscabff.api.service;

import com.hdi.ruralbuscabff.api.constants.SearchConst;
import com.hdi.ruralbuscabff.api.controller.api.BuscaCotacaoResponseApi;
import com.hdi.ruralbuscabff.api.integration.SearchClient;
import com.hdi.ruralbuscabff.api.model.dto.*;
import com.hdi.ruralbuscabff.api.model.dto.queryPolicy.QueryPolicyFilterDto;
import com.hdi.ruralbuscabff.api.model.dto.queryPolicy.QueryPolicyResultDto;
import com.hdi.ruralbuscabff.api.model.emum.SearchFilterEnum;
import com.hdi.ruralbuscabff.api.util.MapQueryPolicyToResponseUtil;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class RuralBuscaService {

    private String target_ebao_search;
    private ModelMapper modelMapper = new ModelMapper();

    public BuscaCotacaoResponseApi buscaPorCotacaoNumero(final BuscaCotacaoDto buscaCotacaoDto) {
//        BuscaCotacaoResponseDto response = BuscaCotacaoResponseDto.builder()
//                .lstCotacoes(new ArrayList<CotacaoDto>())
//                .lstApolices(new ArrayList<ApolicesDto>())
//                .lstEndossos(new ArrayList<EndossoDto>())
//                .build();

        SearchClient searchClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(SearchClient.class))
                .logLevel(Logger.Level.FULL)
                .target(SearchClient.class, target_ebao_search);

        BuscaCotacaoResponseDto response = new BuscaCotacaoResponseDto();
        response.setLstApolices(new ArrayList<ApolicesDto>());
        response.setLstCotacoes(new ArrayList<CotacaoDto>());
        response.setLstEndossos(new ArrayList<EndossoDto>());

        return modelMapper.map(response, BuscaCotacaoResponseApi.class);
    }

    public BuscaCotacaoResponseApi searchByPeriod(final BuscaCotacaoDto buscaCotacao) {
        BuscaCotacaoResponseDto response = new BuscaCotacaoResponseDto();
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(SearchConst.DATE_TIME_DEFAULT_FORMAT);
            LocalDateTime startFrom = LocalDateTime.parse(
                    buscaCotacao.getPeriodoCriacaoCotacao().getDataInicio(), dateTimeFormatter);
            LocalDateTime endTo = LocalDateTime.parse(
                    buscaCotacao.getPeriodoCriacaoCotacao().getDataFinal(), dateTimeFormatter);

            //From Filter
            Map<String, Object> fromRangeConditional = new HashMap();
            fromRangeConditional.put(
                    SearchFilterEnum.PROPOSAL_DATE.getKey(), startFrom.format(DateTimeFormatter.ISO_DATE_TIME));
            //To Filter
            Map<String, Object> toRangeConditional = new HashMap();
            fromRangeConditional.put(
                    SearchFilterEnum.PROPOSAL_DATE.getKey(), endTo.format(DateTimeFormatter.ISO_DATE_TIME));

            QueryPolicyFilterDto queryPolicyFilter = QueryPolicyFilterDto.builder()
                    .fromRangeConditions(fromRangeConditional)
                    .toRangeConditions(fromRangeConditional)
                    .build();

            SearchClient searchClient = Feign.builder()
                    .target(SearchClient.class,
                            "https://sandbox-am-gw.insuremo.com/hdibr/1.0/hdibr-bff-app/v1/policy/query");

            QueryPolicyResultDto result = searchClient.searchByQueryPolicy(queryPolicyFilter);

            //Map result to return BuscaCotacaoResponseDto.
            response = MapQueryPolicyToResponseUtil.mapTo(result);

        } catch (SecurityException ex) {

        } finally {

        }
        return modelMapper.map(response, BuscaCotacaoResponseApi.class);
    }
}
