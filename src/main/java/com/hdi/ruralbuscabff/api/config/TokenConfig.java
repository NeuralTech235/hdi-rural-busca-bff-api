package com.hdi.ruralbuscabff.api.config;

import feign.Logger;
import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TokenConfig {


    private static final String CONTENT_TYPE = "Content-Type";
    private static final String CONTENT_TYPE_HEADER_VALUE = "application/json";

    @Bean
    public RequestInterceptor tokenRequestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header(CONTENT_TYPE, CONTENT_TYPE_HEADER_VALUE);
        };
    }

    @Bean
    public Logger.Level tokenFeignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public ErrorDecoder tokenErrorDecode() {
        return new ErrorDecoder.Default();
    }

    @Bean
    public OkHttpClient tokenOkClient() {
        return new OkHttpClient();
    }

}
