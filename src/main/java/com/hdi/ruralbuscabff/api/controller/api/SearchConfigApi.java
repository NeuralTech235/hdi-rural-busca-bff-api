package com.hdi.ruralbuscabff.api.controller.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchConfigApi {
    @JsonProperty("Module")
    private String module;

    @JsonProperty("PageNo")
    private Integer pageNo;

    @JsonProperty("PageSize")
    private Integer pageSize;

    @JsonProperty("SortField")
    private String sortField;

    @JsonProperty("SortType")
    private String sortType;
}
