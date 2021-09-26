package com.hdi.ruralbuscabff.api.integration;

import com.hdi.ruralbuscabff.api.model.dto.token.TokenMultiClientDto;
import com.hdi.ruralbuscabff.api.model.dto.token.UserDto;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "tokenClient", url = "https://hdibr-gi-sandbox-am.insuremo.com")
public interface TokenClient {
    @Headers("ContentType: application/json")
    @RequestMapping(method = RequestMethod.POST, value = "/v1/json/tickets", consumes = "application/json")
    TokenMultiClientDto getTokenMulticlient(@RequestBody UserDto userDto);
}
