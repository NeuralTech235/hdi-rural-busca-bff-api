package com.hdi.ruralbuscabff.api.controller.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuotationSearchApi {
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
