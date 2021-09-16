package com.hdi.ruralbuscalbff.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OperacaoDto {
    private Integer operacaoId;
    private String  descricaoOperacao;
}
