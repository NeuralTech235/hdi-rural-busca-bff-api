package com.hdi.ruralbuscabff.api.config;

import feign.Logger;
import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SearchConfig {

    private static final String AUTORIZATION_HEADER_VALUE = "Bearer DMJRhNQAQzafobG6Bx_PxA";
    private static final String AUTORIZATION = "Authorization";

    private static final String CONTENT_TYPE = "Content-Type";
    private static final String CONTENT_TYPE_HEADER_VALUE = "application/json";

    private static final String X_EBAO_TENANT_ID = "x-ebao-tenant-id";
    private static final String X_EBAO_TENANT_ID_HEADER_VALUE = "hdibr";

    private static final String X_EBAO_BR_USER_ROLE = "x-ebao-br-user-role";
    private static final String X_EBAO_BR_USER_ROLE_HEADER_VALUE = "admin";

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header(AUTORIZATION, AUTORIZATION_HEADER_VALUE);
            requestTemplate.header(CONTENT_TYPE, CONTENT_TYPE_HEADER_VALUE);
            requestTemplate.header(X_EBAO_TENANT_ID, X_EBAO_TENANT_ID_HEADER_VALUE);
            requestTemplate.header(X_EBAO_BR_USER_ROLE, X_EBAO_BR_USER_ROLE_HEADER_VALUE);
        };
    }

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public ErrorDecoder errorDecode() {
        return new ErrorDecoder.Default();
    }

    public OkHttpClient client(){
        return new OkHttpClient();
    }
}
