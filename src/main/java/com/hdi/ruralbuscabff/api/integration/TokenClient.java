package com.hdi.ruralbuscabff.api.integration;

import com.hdi.ruralbuscabff.api.model.dto.token.TokenMultiClientDto;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="TokenClient",url="{token.host}")
public interface TokenClient {
    @RequestLine("GET /v1/json/tickets")
    TokenMultiClientDto getTokenMulticlient();
}
