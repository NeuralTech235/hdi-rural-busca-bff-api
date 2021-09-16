package com.hdi.ruralbuscabff.api.controller;

import com.hdi.ruralbuscabff.api.service.RuralBuscaService;
import com.hdi.ruralbuscabff.api.controller.api.BuscaCotacaoApi;
import com.hdi.ruralbuscabff.api.controller.api.BuscaCotacaoResponseApi;
import com.hdi.ruralbuscabff.api.model.dto.BuscaCotacaoDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rural/buscas")
@Slf4j
public class RuralBuscaController {
    private RuralBuscaService ruralBuscaBffService;
    private ModelMapper modelMapper;

    @Autowired
    public RuralBuscaController(RuralBuscaService ruralBuscaBffService) {
        this.ruralBuscaBffService = ruralBuscaBffService;
        this.modelMapper = new ModelMapper();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public BuscaCotacaoResponseApi buscaPorNumeroCotacao(@RequestBody BuscaCotacaoApi buscaCotacaoApi) {
        return this.ruralBuscaBffService.buscaPorCotacaoNumero(
                this.modelMapper.map(buscaCotacaoApi, BuscaCotacaoDto.class));
    }
}