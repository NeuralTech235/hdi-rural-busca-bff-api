package com.hdi.ruralbuscabff.api.util;

import com.hdi.ruralbuscabff.api.model.dto.*;
import com.hdi.ruralbuscabff.api.model.dto.queryPolicy.EsDoc;
import com.hdi.ruralbuscabff.api.model.dto.queryPolicy.QueryPolicyResultDto;
import com.hdi.ruralbuscabff.api.model.dto.queryPolicy.ResultDto;
import com.hdi.ruralbuscabff.api.model.emum.TypesEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapQueryPolicyToResponseUtil {
    public BuscaCotacaoResponseDto mapTo(final QueryPolicyResultDto queryPolicyResultDto) {
        BuscaCotacaoResponseDto response = new BuscaCotacaoResponseDto();
        final List<CotacaoDto> quotes = new ArrayList<>();

        Map<String, QueryPolicyResultDto> mapToQuery = new HashMap<>();
        final List<EsDoc> esDocs = queryPolicyResultDto.getResults().stream()
                .map(ResultDto::getEsDocs)
                .flatMap(item -> item.stream())
                .collect(Collectors.toList());
        final Map<String, List<EsDoc>> mapEsDocsTypes = esDocs.stream()
                .collect(Collectors.groupingBy(EsDoc::getProposalStatusDesc, Collectors.toList()));

        if (mapEsDocsTypes.containsKey(TypesEnum.QUOTES.getKey())) {
            response.setLstCotacoes(this.fillQuotations(mapEsDocsTypes.get(TypesEnum.QUOTES.getKey())));
        }
        if (mapEsDocsTypes.containsKey(TypesEnum.PROPOSAL.getKey())) {
            response.setLstProposal(this.fillProposal(mapEsDocsTypes.get(TypesEnum.PROPOSAL.getKey())));
        }
        if (mapEsDocsTypes.containsKey(TypesEnum.POLICIES.getKey())) {
            response.setLstApolices(this.fillPolicies(mapEsDocsTypes.get(TypesEnum.POLICIES.getKey())));
        }
        return response;
    }

    private List<CotacaoDto> fillQuotations(List<EsDoc> esDocs) {
        return esDocs.stream()
                .map(item -> {
                    return CotacaoDto.builder()
                            .quotationNumber(item.getIdNo())
                            .product(ProdutoDto.builder()
                                    .produtoId(item.getProductId())
                                    .descricaoProduto(item.getProductName())
                                    .build())
                            .branchOffice(SucursalDto.builder()
                                    .logradouro(item.getLocCity())
                                    .build())
                            .customerName(item.getCustomerName())
                            .cpfcnpj(item.getIdNo())
                            .validity(PeriodoDto.builder()
                                    .dataInicio(item.getEffectiveDate())
                                    .dataFinal(item.getExpiryDate())
                                    .build())
                            .operation(OperacaoDto.builder()
                                    .operacaoId(12345)
                                    .descricaoOperacao("Ind.-Novos Negocios")
                                    .build())
                            .applicationUser(UsuarioDto.builder()
                                    .usuarioId(item.getAgentIdNo())
                                    .build())
                            .item(ItemDto.builder()
                                    .build()
                            )
                            .build();
                })
                .collect(Collectors.toList());
    }

    private List<ProposalDto> fillProposal(List<EsDoc> esDocs) {
        return esDocs.stream()
                .map(item -> {
                    return ProposalDto.builder()
                            .quotationNumber(item.getIdNo())
                            .product(ProdutoDto.builder()
                                    .produtoId(item.getProductId())
                                    .descricaoProduto(item.getProductName())
                                    .build())
                            .branchOffice(SucursalDto.builder()
                                    .logradouro(item.getLocCity())
                                    .build())
                            .customerName(item.getCustomerName())
                            .cpfcnpj(item.getIdNo())
                            .validity(PeriodoDto.builder()
                                    .dataInicio(item.getEffectiveDate())
                                    .dataFinal(item.getExpiryDate())
                                    .build())
                            .operation(OperacaoDto.builder()
                                    .operacaoId(12345)
                                    .descricaoOperacao("Ind.-Novos Negocios")
                                    .build())
                            .applicationUser(UsuarioDto.builder()
                                    .usuarioId(item.getAgentIdNo())
                                    .build())
                            .item(ItemDto.builder()
                                    .build()
                            )
                            .build();
                })
                .collect(Collectors.toList());
    }

    private List<ApolicesDto> fillPolicies(List<EsDoc> esDocs) {
        return esDocs.stream()
                .map(item -> {
                    return ApolicesDto.builder()
                            .quotationNumber(item.getIdNo())
                            .product(ProdutoDto.builder()
                                    .produtoId(item.getProductId())
                                    .descricaoProduto(item.getProductName())
                                    .build()
                            )
                            .customerName(item.getCustomerName())
                            .cpfcnpj(item.getIdNo())
                            .insuranceBrokerDoc(item.getInsuredIdNo())
                            .transmission("Worksite")
                            .validity(PeriodoDto.builder()
                                    .dataInicio(item.getEffectiveDate())
                                    .dataFinal(item.getExpiryDate())
                                    .build()
                            )
                            .policeIssueDate(item.getFirstDataEntryDate())
                            .applicationUser(UsuarioDto.builder()
                                    .usuarioId("3333333333333333")
                                    .nomeUsuario("Paulo Sperb Cor CXS")
                                    .build()
                            )
                            .welcomeKit(item.getWelcomeKit())
                            .item(ItemDto.builder()
                                    .item("000001")
                                    .description("WOLKSWAGEM Polo 1.6 MSI Total Flex 5p Aut.")
                                    .placa("ZZZ-0000")
                                    .chassi("xptojhshshshs")
                                    .anoFabr("2019")
                                    .modelo("2019")
                                    .build()
                            )
                            .operation(OperacaoDto.builder()
                                    .descricaoOperacao("Ind.-Novos Negocios")
                                    .operacaoId(1)
                                    .build()
                            )
                            .bonus("0,00%")
                            .build();
                })
                .collect(Collectors.toList());
    }
}