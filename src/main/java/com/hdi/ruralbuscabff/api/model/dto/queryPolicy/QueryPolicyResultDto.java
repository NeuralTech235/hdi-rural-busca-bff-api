package com.hdi.ruralbuscabff.api.model.dto.queryPolicy;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QueryPolicyResultDto {
    @JsonProperty("GroupField")
    private String groupField;
    @JsonProperty("PageNo")
    private Integer pageNo;
    @JsonProperty("PageSize")
    private Integer pageSize;
    @JsonProperty("Results")
    private List<ResultDto> results;
    @JsonProperty("Total")
    private Long total;
}
