package com.hdi.ruralbuscabff.api.integration;

import com.hdi.ruralbuscabff.api.model.dto.BuscaCotacaoResponseDto;
import com.hdi.ruralbuscabff.api.model.dto.queryPolicy.QueryPolicyFilterDto;
import com.hdi.ruralbuscabff.api.model.dto.queryPolicy.QueryPolicyResultDto;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface SearchClient {
    @RequestLine("GET /{isbn}")
    BuscaCotacaoResponseDto searchByProposeNumber(@Param("isbn") String isbn);

    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    QueryPolicyResultDto searchByQueryPolicy(QueryPolicyFilterDto queryPolicy);
}
