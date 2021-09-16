package com.hdi.ruralbuscalbff.api.controller.api;

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
    private LocalDate dataInicio;
    private LocalDate dataFinal;
}