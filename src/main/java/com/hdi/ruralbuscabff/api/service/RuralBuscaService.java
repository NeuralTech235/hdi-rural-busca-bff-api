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
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
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
            fromRangeConditional.put(
                    SearchFilterEnum.PROPOSAL_DATE.getKey(), endTo.format(DateTimeFormatter.ISO_DATE_TIME));

            QueryPolicyFilterDto queryPolicyFilter = QueryPolicyFilterDto.builder()
                    .fromRangeConditions(fromRangeConditional)
                    .toRangeConditions(fromRangeConditional)
                    .build();

            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            headers.put("Authorization", Collections.singletonList("Bearer xqWgOQ8MT8KQ8jvRIz65vw"));
            headers.put("Content-Type", Collections.singletonList("appication/json"));
            headers.put("x-ebao-tenant-id", Collections.singletonList("hdibr"));
            headers.put("x-ebao-br-user-role", Collections.singletonList("admin"));

            QueryPolicyResultDto result = searchClient.searchByQueryPolicy(headers, queryPolicyFilter);

            //Map result to return BuscaCotacaoResponseDto.
            response = MapQueryPolicyToResponseUtil.mapTo(result);

        } catch (SecurityException ex) {

        } finally {

        }
        return modelMapper.map(response, BuscaCotacaoResponseApi.class);
    }
}
