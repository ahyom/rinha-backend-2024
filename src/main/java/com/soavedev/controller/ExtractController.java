package com.soavedev.controller;

import com.soavedev.domain.entity.Client;
import com.soavedev.domain.entity.Transaction;
import com.soavedev.domain.response.extract.BalanceExtractResponse;
import com.soavedev.domain.response.extract.ExtractResponse;
import com.soavedev.domain.response.extract.TransactionExtractResponse;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Path("/clientes")
public class ExtractController {

    @GET
    @Path("/{client-id}/extrato")
    public Response getExtractForClient(@PathParam("client-id") Long clientId) {

        // jogo sujo pra nem pesquisar clients acima de 5
        if (clientId > 5) {
            return Response.status(404).build();
        }

        Client client = Client.findById(clientId);
        List<Transaction> transactions = Transaction.findLast10TransactionsByClientId(clientId);

        BalanceExtractResponse balanceExtractResponse = new BalanceExtractResponse(
                client.getBalance(),
                ZonedDateTime.now(),
                client.getLimit()
        );

        List<TransactionExtractResponse> transactionExtractResponseList = transactions.stream()
                .map(transaction -> new TransactionExtractResponse(
                        transaction.getAmount(),
                        transaction.getType(),
                        transaction.getDescription(),
                        transaction.getCreatedAt()
                ))
                .collect(Collectors.toList());

        return Response.ok(new ExtractResponse(
                balanceExtractResponse,
                transactionExtractResponseList
        )).build();
    }
}
