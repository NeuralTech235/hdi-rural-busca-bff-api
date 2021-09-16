package com.hdi.ruralbuscabff.api.controller.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EndossoApi {
    private Integer numeroCotacao;
    private ProdutoApi produto;
    private SucursalApi sucursal;
    private String nomeCliente;
    private String documento;
    private PeriodoApi vigencia;
    private OperacaoApi operacao;
    private UsuarioApi usuario;
    private ItemApi item;
}
