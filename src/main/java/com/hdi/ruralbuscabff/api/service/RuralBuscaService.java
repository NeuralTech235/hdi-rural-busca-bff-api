package com.hdi.ruralbuscabff.api.service;

import com.hdi.ruralbuscabff.api.constants.SearchConst;
import com.hdi.ruralbuscabff.api.controller.api.BuscaCotacaoResponseApi;
import com.hdi.ruralbuscabff.api.integration.SearchClient;
import com.hdi.ruralbuscabff.api.model.dto.BuscaCotacaoDto;
import com.hdi.ruralbuscabff.api.model.dto.BuscaCotacaoResponseDto;
import com.hdi.ruralbuscabff.api.model.dto.queryPolicy.QueryPolicyFilterDto;
import com.hdi.ruralbuscabff.api.model.dto.queryPolicy.QueryPolicyResultDto;
import com.hdi.ruralbuscabff.api.model.emum.SearchFilterEnum;
import com.hdi.ruralbuscabff.api.util.MapQueryPolicyToResponseUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Service
public class RuralBuscaService {

    private SearchClient searchClient;
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public RuralBuscaService(SearchClient searchClient) {
        this.searchClient = searchClient;
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
            toRangeConditional.put(
                    SearchFilterEnum.PROPOSAL_DATE.getKey(), endTo.format(DateTimeFormatter.ISO_DATE_TIME));

            QueryPolicyFilterDto queryPolicyFilter = QueryPolicyFilterDto.builder()
                    .fromRangeConditions(fromRangeConditional)
                    .toRangeConditions(toRangeConditional)
                    .module("Policy")
                    .pageNo(1)
                    .pageSize(1000)
                    .sortField("EffectiveDate")
                    .sortType("desc")
                    .build();

            QueryPolicyResultDto result = searchClient.searchByQueryPolicy(queryPolicyFilter);
            response = (new MapQueryPolicyToResponseUtil()).mapTo(result);

        } catch (SecurityException ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("End process");
        }
        return modelMapper.map(response, BuscaCotacaoResponseApi.class);
    }
}
