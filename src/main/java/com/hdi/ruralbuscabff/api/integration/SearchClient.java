package com.hdi.ruralbuscabff.api.integration;

import com.hdi.ruralbuscabff.api.model.dto.queryPolicy.QueryPolicyFilterDto;
import com.hdi.ruralbuscabff.api.model.dto.queryPolicy.QueryPolicyResultDto;
import feign.HeaderMap;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "searchClient", url = "https://sandbox-am-gw.insuremo.com/hdibr/1.0/hdibr-bff-app")
public interface SearchClient {
    @RequestMapping(method = RequestMethod.POST, value = "/v1/policy/query", consumes = "application/json")
    QueryPolicyResultDto searchByQueryPolicy(@HeaderMap MultiValueMap<String, String> headers, @RequestBody QueryPolicyFilterDto queryPolicy);
}
