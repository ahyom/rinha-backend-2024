package com.soavedev.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.soavedev.domain.entity.Transaction;

import java.time.ZonedDateTime;

public class TransactionRequest {


        @JsonProperty("valor")
        int amount;

        @JsonProperty("tipo")
        String type;

        @JsonProperty("descricao")
        String description;

        public int getAmount() {
                return amount;
        }

        public String getType() {
                return type;
        }

        public String getDescription() {
                return description;
        }

        public static Transaction toEntity(TransactionRequest req) {
                Transaction t = new Transaction();
                t.setAmount(req.getAmount());
                t.setType(req.getType());
                t.setDescription(req.getDescription());
                t.setCreatedAt(ZonedDateTime.now());
                t.setClient(null);
                return t;
        }
}
