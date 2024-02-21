package com.soavedev.domain.response.extract;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ExtractResponse(
        @JsonProperty("saldo")
        BalanceExtractResponse balanceExtractResponse,

        @JsonProperty("ultimas_transacoes")
        List<TransactionExtractResponse> transactions
) {
}
