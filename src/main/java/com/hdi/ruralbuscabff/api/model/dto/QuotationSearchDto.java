package com.hdi.ruralbuscabff.api.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hdi.ruralbuscabff.api.controller.api.PeriodoApi;
import com.hdi.ruralbuscabff.api.controller.api.SearchConfigApi;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuotationSearchDto {
    @JsonProperty("numeroDaCotacao")
    private Integer numeroDaCotacao;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("docCPF")
    private String docCPF;

    @JsonProperty("docCNPJ")
    private String docCNPJ;

    @JsonProperty("periodoCriacaoCotacao")
    private PeriodoApi periodoCriacaoCotacao;

    @JsonProperty("searchConfig")
    private SearchConfigApi config;
}
