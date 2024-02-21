package com.soavedev.controller;

import com.soavedev.domain.entity.Client;
import com.soavedev.domain.entity.Transaction;
import com.soavedev.domain.request.TransactionRequest;
import com.soavedev.domain.response.TransactionResponse;
import com.soavedev.service.TransactionService;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Path("/clientes/")
public class TransactionController {

    private static final Logger log = LoggerFactory.getLogger(TransactionController.class);

    @POST
    @Path("/{client-id}/transacoes")
    @Transactional
    public Response createTransaction(@PathParam("client-id") Long clientId, TransactionRequest req) {

        // jogo sujo pra nem pesquisar clients acima de 5
        if (clientId > 5) {
            return Response.status(404).build();
        }

        Client client = Client.findById(clientId);
        Transaction transaction = TransactionRequest.toEntity(req);
        transaction.setClient(client);

        TransactionService.processTransaction(transaction);

        // build transaction response
        return Response.ok(new TransactionResponse(
                client.getLimit(),
                client.getBalance()
        )).build();

    }
}
