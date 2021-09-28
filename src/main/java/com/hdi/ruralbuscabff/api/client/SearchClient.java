package com.hdi.ruralbuscabff.api.client;

import com.hdi.ruralbuscabff.api.config.SearchConfig;
import com.hdi.ruralbuscabff.api.model.dto.queryPolicy.QueryPolicyFilterDto;
import com.hdi.ruralbuscabff.api.model.dto.queryPolicy.QueryPolicyResultDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "searchClient",
        url = "${rural-busca-bff.queryPolicy.url}",
        configuration = SearchConfig.class)
public interface SearchClient {
    @RequestMapping(method = RequestMethod.POST, value = "/v1/policy/query", consumes = "application/json")
    QueryPolicyResultDto searchByQueryPolicy(@RequestBody QueryPolicyFilterDto queryPolicy);
}