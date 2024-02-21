package com.soavedev.controller;

import com.soavedev.domain.entity.Client;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/clientes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClientController {

    @GET
    public Response getAllClients() {
        List<Client> clients = Client.listAll();
        return Response.ok(clients).build();
    }

}
