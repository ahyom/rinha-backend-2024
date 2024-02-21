package com.soavedev.domain.response.extract;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;

public record BalanceExtractResponse(
        @JsonProperty("total")
        int balance,

        @JsonProperty("data_extrato")
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSZ")
        ZonedDateTime extractDate,

        @JsonProperty("limite")
        int limit
) {
}
