package com.hdi.ruralbuscabff.api.controller.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuscaCotacaoResponseApi {
    private List<CotacaoApi>lstCotacoes;
    private List<ApolicesApi>lstApolices;
    private List<EndossoApi>lstEndossos;
}