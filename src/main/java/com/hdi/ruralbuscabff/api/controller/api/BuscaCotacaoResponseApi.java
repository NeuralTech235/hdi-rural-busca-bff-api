package com.hdi.ruralbuscabff.api.controller.api;

import com.hdi.ruralbuscabff.api.model.dto.ApolicesDto;
import com.hdi.ruralbuscabff.api.model.dto.CotacaoDto;
import com.hdi.ruralbuscabff.api.model.dto.ProposalDto;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Builder
public class BuscaCotacaoResponseApi {
    public BuscaCotacaoResponseApi(List<CotacaoDto> lstCotacoes, List<ApolicesDto> lstApolices, List<ProposalDto> lstProposal) {
        this.lstCotacoes = lstCotacoes;
        this.lstApolices = lstApolices;
        this.lstProposal = lstProposal;
    }

    private List<CotacaoDto> lstCotacoes;
    private List<ApolicesDto> lstApolices;
    private List<ProposalDto> lstProposal;
}