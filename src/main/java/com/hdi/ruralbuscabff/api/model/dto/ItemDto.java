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
public class ItemDto {
    @JsonProperty("item")
    private String item;

    @JsonProperty("description")
    private String description;

    @JsonProperty("placa")
    private String placa;

    @JsonProperty("chassi")
    private String chassi;

    @JsonProperty("anoFabricacao")
    private String anoFabr;

    @JsonProperty("modeloFabricacao")
    private String modelo;
}
