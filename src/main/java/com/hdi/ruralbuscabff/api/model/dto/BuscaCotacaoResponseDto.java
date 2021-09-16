package com.hdi.ruralbuscabff.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Builder
public class BuscaCotacaoResponseDto {
    public BuscaCotacaoResponseDto(List<CotacaoDto> lstCotacoes, List<ApolicesDto> lstApolices, List<EndossoDto> lstEndossos) {
        this.lstCotacoes = lstCotacoes;
        this.lstApolices = lstApolices;
        this.lstEndossos = lstEndossos;
    }

    private List<CotacaoDto>lstCotacoes;
    private List<ApolicesDto>lstApolices;
    private List<EndossoDto>lstEndossos;
}