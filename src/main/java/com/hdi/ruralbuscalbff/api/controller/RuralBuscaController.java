package com.hdi.ruralbuscalbff.api.controller;

import com.hdi.ruralbuscalbff.api.controller.api.BuscaCotacaoApi;
import com.hdi.ruralbuscalbff.api.controller.api.BuscaCotacaoResponseApi;
import com.hdi.ruralbuscalbff.api.model.dto.BuscaCotacaoDto;
import com.hdi.ruralbuscalbff.api.service.RuralBuscaService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(maxAge = 3600)
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

    @PostMapping()
    public BuscaCotacaoResponseApi buscaPorNumeroCotacao(@RequestBody BuscaCotacaoApi buscaCotacaoApi) {
        return this.ruralBuscaBffService.buscaPorCotacaoNumero(
                this.modelMapper.map(buscaCotacaoApi, BuscaCotacaoDto.class));
    }
}