package com.hdi.ruralbuscabff.api.util;

import com.hdi.ruralbuscabff.api.model.dto.BuscaCotacaoResponseDto;
import com.hdi.ruralbuscabff.api.model.dto.queryPolicy.EsDoc;
import com.hdi.ruralbuscabff.api.model.dto.queryPolicy.QueryPolicyResultDto;
import com.hdi.ruralbuscabff.api.model.dto.queryPolicy.ResultDto;
import com.hdi.ruralbuscabff.api.model.emum.TypesEnum;

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
        final Map<Integer, List<EsDoc>> mapEsDocsTypes = esDocs.stream()
                .collect(Collectors.groupingBy(EsDoc::getProposalStatus, Collectors.toList()));
        final Map<String, List<EsDoc>> mapTypes = new HashMap<>();
        mapEsDocsTypes.forEach((k, v) -> {
            switch (k) {
                case 1:
                    mapTypes.put(TypesEnum.POLICIES.getKey(), v);
                case 2:
                    mapTypes.put(TypesEnum.PROPOSAL.getKey(), v);
                case 3:
                    mapTypes.put(TypesEnum.PROPOSAL.getKey(), v);
                default:
                    mapTypes.put(TypesEnum.NOT_DEFINED.getKey(), v);
            }
        });

        return new BuscaCotacaoResponseDto();
    }
}
