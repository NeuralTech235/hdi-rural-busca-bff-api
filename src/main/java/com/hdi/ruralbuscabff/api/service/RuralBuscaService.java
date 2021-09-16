package com.hdi.ruralbuscabff.api.service;

import com.hdi.ruralbuscabff.api.controller.api.BuscaCotacaoResponseApi;
import com.hdi.ruralbuscabff.api.model.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class RuralBuscaService {

    private ModelMapper modelMapper = new ModelMapper();

    public BuscaCotacaoResponseApi buscaPorCotacaoNumero(final BuscaCotacaoDto buscaCotacaoDto) {
//        BuscaCotacaoResponseDto response = BuscaCotacaoResponseDto.builder()
//                .lstCotacoes(new ArrayList<CotacaoDto>())
//                .lstApolices(new ArrayList<ApolicesDto>())
//                .lstEndossos(new ArrayList<EndossoDto>())
//                .build();
         BuscaCotacaoResponseDto response = new BuscaCotacaoResponseDto();
         response.setLstApolices(new ArrayList<ApolicesDto>());
         response.setLstCotacoes(new ArrayList<CotacaoDto>());
         response.setLstEndossos(new ArrayList<EndossoDto>());

        return modelMapper.map(response, BuscaCotacaoResponseApi.class);
    }
}
