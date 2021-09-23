package com.hdi.ruralbuscabff.api.model.dto.queryPolicy;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QueryPolicyFilterDto {

    @JsonProperty("Conditions")
    private Map<String,Object> conditions;
    @JsonProperty("InConditions")
    private Map<String,Object> inConditions;
    @JsonProperty("NotInConditions")
    private Map<String,Object> notInConditions;
    @JsonProperty("FuzzyConditions")
    private Map<String,Object> fuzzyConditions;
    @JsonProperty("FromRangeConditions")
    private Map<String,Object> orFuzzyConditions;
    @JsonProperty("FromRangeConditions")
    private Map<String,Object> fromRangeConditions;
    @JsonProperty("ToRangeConditions")
    private Map<String,Object> toRangeConditions;

    @JsonProperty("PageNo")
    private String pageNo;
    @JsonProperty("PageSize")
    private String pageSize;
    @JsonProperty("SortField")
    private String sortField;
    @JsonProperty("SortType")
    private String sortType;
    @JsonProperty("Module")
    private String module;

}
