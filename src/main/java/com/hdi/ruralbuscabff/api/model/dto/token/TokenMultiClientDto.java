package com.hdi.ruralbuscabff.api.model.dto.token;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TokenMultiClientDto {
    @JsonProperty("access_token")
    private String access_token;

    @JsonProperty("authResult")
    private String authResult;

    @JsonProperty("expire_in")
    private Integer expire_in;

    @JsonProperty("message")
    private String message;

    @JsonProperty("retry_times")
    private Integer retry_times;
}
