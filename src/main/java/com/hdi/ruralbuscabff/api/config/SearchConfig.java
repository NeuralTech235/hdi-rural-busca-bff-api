package com.hdi.ruralbuscabff.api.config;

import com.hdi.ruralbuscabff.api.client.TokenClient;
import com.hdi.ruralbuscabff.api.model.dto.token.TokenMultiClientDto;
import com.hdi.ruralbuscabff.api.model.dto.token.UserDto;
import feign.Logger;
import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import feign.okhttp.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SearchConfig {

    @Value("${rural-busca-bff.getToken.username}")
    private String username;
    @Value("${rural-busca-bff.getToken.password}")
    private String password;

    private static final String AUTORIZATION_HEADER_VALUE = "Bearer ";
    private static final String AUTORIZATION = "Authorization";

    private static final String CONTENT_TYPE = "Content-Type";
    private static final String CONTENT_TYPE_HEADER_VALUE = "application/json";

    private static final String X_EBAO_TENANT_ID = "x-ebao-tenant-id";
    private static final String X_EBAO_TENANT_ID_HEADER_VALUE = "hdibr";

    private static final String X_EBAO_BR_USER_ROLE = "x-ebao-br-user-role";
    private static final String X_EBAO_BR_USER_ROLE_HEADER_VALUE = "admin";

    private TokenClient tokenClient;

    @Autowired
    public SearchConfig(TokenClient tokenClient) {
        this.tokenClient = tokenClient;
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header(AUTORIZATION, this.getToken());
            requestTemplate.header(CONTENT_TYPE, CONTENT_TYPE_HEADER_VALUE);
            requestTemplate.header(X_EBAO_TENANT_ID, X_EBAO_TENANT_ID_HEADER_VALUE);
            requestTemplate.header(X_EBAO_BR_USER_ROLE, X_EBAO_BR_USER_ROLE_HEADER_VALUE);
        };
    }

    private String getToken() {
        final UserDto user = UserDto.builder()
                .username(username)
                .password(password)
                .build();
        TokenMultiClientDto tokenMultiClientDto = tokenClient.getTokenMulticlient(user);
        return AUTORIZATION_HEADER_VALUE.concat(tokenMultiClientDto.getAccess_token());
    }

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public ErrorDecoder errorDecode() {
        return new ErrorDecoder.Default();
    }

    public OkHttpClient client() {
        return new OkHttpClient();
    }
}
