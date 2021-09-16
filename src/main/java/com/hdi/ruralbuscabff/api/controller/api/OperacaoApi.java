package com.hdi.ruralbuscabff.api.controller.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OperacaoApi {
    private Integer operacaoId;
    private String  descricaoOperacao;
}
