package com.hdi.ruralbuscabff.api.client;

import com.hdi.ruralbuscabff.api.config.TokenConfig;
import com.hdi.ruralbuscabff.api.model.dto.token.TokenMultiClientDto;
import com.hdi.ruralbuscabff.api.model.dto.token.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "tokenClient",
        url = "${rural-busca-bff.getToken.url}",
        configuration = TokenConfig.class)
public interface TokenClient {
    @RequestMapping(method = RequestMethod.POST, value = "/v1/json/tickets", consumes = "application/json")
    TokenMultiClientDto getTokenMulticlient(@RequestBody UserDto userDto);
}
