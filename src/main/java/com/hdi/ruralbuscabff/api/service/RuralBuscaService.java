package com.hdi.ruralbuscabff.api.service;

import com.hdi.ruralbuscabff.api.constants.SearchConst;
import com.hdi.ruralbuscabff.api.controller.api.BuscaCotacaoResponseApi;
import com.hdi.ruralbuscabff.api.integration.SearchClient;
import com.hdi.ruralbuscabff.api.model.dto.QuotationSearchDto;
import com.hdi.ruralbuscabff.api.model.dto.BuscaCotacaoResponseDto;
import com.hdi.ruralbuscabff.api.model.dto.queryPolicy.QueryPolicyFilterDto;
import com.hdi.ruralbuscabff.api.model.dto.queryPolicy.QueryPolicyResultDto;
import com.hdi.ruralbuscabff.api.model.emum.SearchFilterEnum;
import com.hdi.ruralbuscabff.api.util.MapQueryPolicyToResponseUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    Logger log = LogManager.getLogger(RuralBuscaService.class);

    @Autowired
    public RuralBuscaService(SearchClient searchClient) {
        this.searchClient = searchClient;
    }

    public BuscaCotacaoResponseApi searchByPeriod(final QuotationSearchDto buscaCotacao) {
        BuscaCotacaoResponseDto response = new BuscaCotacaoResponseDto();
        log.info("Start SearchByPeriod process!");
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
                    .pageSize(10)
                    .sortField("EffectiveDate")
                    .sortType("desc")
                    .build();

            QueryPolicyResultDto result = searchClient.searchByQueryPolicy(queryPolicyFilter);
            response = (new MapQueryPolicyToResponseUtil()).mapTo(result);

        } catch (SecurityException ex) {
            log.error("Error SearchByPeriod execution process!");
            ex.printStackTrace();
        } finally {
            log.info("Start SearchByPeriod process!");
        }
        return modelMapper.map(response, BuscaCotacaoResponseApi.class);
    }
}
