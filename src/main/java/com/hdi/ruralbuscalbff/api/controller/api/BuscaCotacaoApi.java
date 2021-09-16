package com.hdi.ruralbuscalbff.api.controller.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuscaCotacaoApi {
    private Integer numeroDaCotacao;
    private String nome;
    private String docCPF;
    private String docCNPJ;
    private PeriodoApi periodoCriacaoCotacao;
}
