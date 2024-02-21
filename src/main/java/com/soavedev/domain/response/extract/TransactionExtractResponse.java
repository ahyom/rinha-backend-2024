package com.soavedev.domain.response.extract;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;

public record TransactionExtractResponse(
        @JsonProperty("valor")
        int amount,

        @JsonProperty("tipo")
        String type,

        @JsonProperty("descricao")
        String description,

        @JsonProperty("realizada_em")
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSZ")
        ZonedDateTime createdAt
) {
}
