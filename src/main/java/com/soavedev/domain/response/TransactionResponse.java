package com.soavedev.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TransactionResponse(
        @JsonProperty("limite")
        int limit,

        @JsonProperty("saldo")
        int balance
) {
}
