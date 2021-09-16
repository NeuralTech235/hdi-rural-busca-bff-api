package com.hdi.ruralbuscalbff.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApolicesDto {
    private Integer numeroCotacao;
    private ProdutoDto produto;
    private SucursalDto sucursal;
    private String nomeCliente;
    private String documento;
    private PeriodoDto vigencia;
    private OperacaoDto operacao;
    private UsuarioDto usuario;
    private ItemDto item;
}
