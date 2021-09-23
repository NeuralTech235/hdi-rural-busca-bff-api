package com.hdi.ruralbuscabff.api.service;

import com.hdi.ruralbuscabff.api.controller.api.BuscaCotacaoResponseApi;
import com.hdi.ruralbuscabff.api.integration.SearchClient;
import com.hdi.ruralbuscabff.api.model.dto.*;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class RuralBuscaService {

    private String target_ebao_search;
    private ModelMapper modelMapper = new ModelMapper();

    public BuscaCotacaoResponseApi buscaPorCotacaoNumero(final BuscaCotacaoDto buscaCotacaoDto) {
//        BuscaCotacaoResponseDto response = BuscaCotacaoResponseDto.builder()
//                .lstCotacoes(new ArrayList<CotacaoDto>())
//                .lstApolices(new ArrayList<ApolicesDto>())
//                .lstEndossos(new ArrayList<EndossoDto>())
//                .build();

        SearchClient searchClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(SearchClient.class))
                .logLevel(Logger.Level.FULL)
                .target(SearchClient.class, target_ebao_search);

        BuscaCotacaoResponseDto response = new BuscaCotacaoResponseDto();
        response.setLstApolices(new ArrayList<ApolicesDto>());
        response.setLstCotacoes(new ArrayList<CotacaoDto>());
        response.setLstEndossos(new ArrayList<EndossoDto>());

        return modelMapper.map(response, BuscaCotacaoResponseApi.class);
    }

    public BuscaCotacaoResponseApi searchByPeriod(final String startPeriod, final String endPeriod ) {

        return modelMapper.map(response, BuscaCotacaoResponseApi.class);
    }


}
