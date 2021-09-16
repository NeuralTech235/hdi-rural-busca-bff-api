package com.hdi.ruralbuscalbff.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuscaCotacaoResponseDto {
    private List<CotacaoDto>lstCotacoes;
    private List<ApolicesDto>lstApolices;
    private List<EndossoDto>lstEndossos;
}