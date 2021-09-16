package com.hdi.ruralbuscalbff.api.service;

import com.hdi.ruralbuscalbff.api.controller.api.BuscaCotacaoResponseApi;
import com.hdi.ruralbuscalbff.api.model.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class RuralBuscaService {

    private ModelMapper modelMapper;

    public RuralBuscaService(final ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public BuscaCotacaoResponseApi buscaPorCotacaoNumero(final BuscaCotacaoDto buscaCotacaoDto) {
        return modelMapper.map(BuscaCotacaoResponseDto.builder()
                .lstCotacoes(new ArrayList<CotacaoDto>())
                .lstApolices(new ArrayList<ApolicesDto>())
                .lstEndossos(new ArrayList<EndossoDto>())
                .build(), BuscaCotacaoResponseApi.class);
    }
}
