package com.hdi.ruralbuscalbff.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PeriodoDto {
    private LocalDate dataInicio;
    private LocalDate dataFinal;
}