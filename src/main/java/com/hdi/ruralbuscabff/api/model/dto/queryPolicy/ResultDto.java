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
public class ResultDto {
    @JsonProperty("EsDocs")
    private List<EsDoc> esDocs;
    @JsonProperty("GroupsTotalNum")
    private Long groupsTotalNum;
    @JsonProperty("GroupValue")
    private String groupValue;
}
