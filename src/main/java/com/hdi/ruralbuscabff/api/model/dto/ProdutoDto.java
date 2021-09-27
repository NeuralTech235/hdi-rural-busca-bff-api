package com.hdi.ruralbuscabff.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdutoDto {

    private Long produtoId;
    private String descricaoProduto;
}