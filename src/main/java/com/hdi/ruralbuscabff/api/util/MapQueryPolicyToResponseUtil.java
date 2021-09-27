package com.hdi.ruralbuscabff.api.util;

import com.hdi.ruralbuscabff.api.model.dto.BuscaCotacaoResponseDto;
import com.hdi.ruralbuscabff.api.model.dto.queryPolicy.EsDoc;
import com.hdi.ruralbuscabff.api.model.dto.queryPolicy.QueryPolicyResultDto;
import com.hdi.ruralbuscabff.api.model.dto.queryPolicy.ResultDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapQueryPolicyToResponseUtil {
    public static BuscaCotacaoResponseDto mapTo(final QueryPolicyResultDto queryPolicyResultDto) {
        Map<String, QueryPolicyResultDto> mapToQuery = new HashMap<>();
        final List<EsDoc> esDocs = queryPolicyResultDto.getResults().stream()
                .map(ResultDto::getEsDocs)
                .flatMap(item -> item.stream())
                .collect(Collectors.toList());
        final Map<String, List<EsDoc>> mapEsDocsTypes = esDocs.stream()
                .collect(Collectors.groupingBy(EsDoc::getProposalStatusDesc, Collectors.toList()));
        return new BuscaCotacaoResponseDto();
    }
}
