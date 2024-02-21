package com.soavedev.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ErrorResponse(
        @JsonProperty("http_code")
        int httpCode,
        String description
) {
}
