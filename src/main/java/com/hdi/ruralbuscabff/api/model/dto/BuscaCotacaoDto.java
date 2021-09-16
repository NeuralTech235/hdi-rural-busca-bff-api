package com.hdi.ruralbuscabff.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuscaCotacaoDto {
    private Integer numeroDaCotacao;
    private String nome;
    private String docCPF;
    private String docCNPJ;
    private PeriodoDto periodoCriacaoCotacao;
}
