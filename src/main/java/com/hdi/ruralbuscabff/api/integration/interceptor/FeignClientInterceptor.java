package com.hdi.ruralbuscabff.api.integration.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class FeignClientInterceptor implements RequestInterceptor {
    private static final String AUTORIZATION_HEADER = "Authorization: Bearer ";

    @Override
    public void apply(RequestTemplate requestTemplate) {

        requestTemplate.header(AUTORIZATION_HEADER);
    }
}
