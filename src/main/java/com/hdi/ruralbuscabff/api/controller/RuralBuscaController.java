package com.hdi.ruralbuscabff.api.controller;

import com.hdi.ruralbuscabff.api.controller.api.QuotationSearchApi;
import com.hdi.ruralbuscabff.api.controller.api.BuscaCotacaoResponseApi;
import com.hdi.ruralbuscabff.api.model.dto.QuotationSearchDto;
import com.hdi.ruralbuscabff.api.service.RuralBuscaService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rural/buscas")
@Slf4j
public class RuralBuscaController {

    private RuralBuscaService ruralBuscaBffService;
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public RuralBuscaController(RuralBuscaService ruralBuscaBffService) {
        this.ruralBuscaBffService = ruralBuscaBffService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public BuscaCotacaoResponseApi searchByPeriod(@RequestBody QuotationSearchApi quotationSearchApi) {
        return this.ruralBuscaBffService.searchByPeriod(
                this.modelMapper.map(quotationSearchApi, QuotationSearchDto.class));
    }
}