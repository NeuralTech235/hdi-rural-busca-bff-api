package com.hdi.ruralbuscabff.api.controller.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PeriodoApi {
    @JsonProperty("dataInicio")
    private String dataInicio;
    @JsonProperty("dataFinal")
    private String dataFinal;
}