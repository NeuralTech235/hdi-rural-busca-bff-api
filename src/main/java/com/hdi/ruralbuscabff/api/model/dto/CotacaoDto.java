package com.hdi.ruralbuscabff.api.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CotacaoDto {

    @JsonProperty("cotacaoNumero")
    private String quotationNumber;

    @JsonProperty("produto")
    private ProdutoDto product;

    @JsonProperty("filial")
    private SucursalDto branchOffice;

    @JsonProperty("nomeCliente")
    private String customerName;

    @JsonProperty("cpfcnpj")
    private String cpfcnpj;

    @JsonProperty("vigencia")
    private PeriodoDto validity;

    @JsonProperty("operação")
    private OperacaoDto operation;

    @JsonProperty("usuario")
    private UsuarioDto applicationUser;

    @JsonProperty("item")
    private ItemDto item;

}
