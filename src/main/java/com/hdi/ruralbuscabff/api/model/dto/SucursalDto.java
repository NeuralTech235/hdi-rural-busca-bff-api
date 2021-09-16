package com.hdi.ruralbuscabff.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SucursalDto {
    private Integer sucursalId;
    private String nome;
    private String logradouro;
}
