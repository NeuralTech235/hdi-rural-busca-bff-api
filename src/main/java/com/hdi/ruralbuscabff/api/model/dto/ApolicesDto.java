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
public class ApolicesDto {
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

    @JsonProperty("doctoCorretor")
    private String insuranceBrokerDoc;

    @JsonProperty("transmissao")
    private String transmission;

    @JsonProperty("emissao")
    private String policeIssueDate;

    @JsonProperty("statusProposta")
    private String proposalStatus;

    @JsonProperty("usuario")
    private UsuarioDto applicationUser;

    @JsonProperty("kitBoasVindas")
    private String welcomeKit;

    @JsonProperty("item")
    private ItemDto item;

    @JsonProperty("operação")
    private OperacaoDto operation;

    @JsonProperty("bonus")
    private String bonus;
}
