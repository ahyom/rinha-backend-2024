package com.soavedev.controller.advisor;

import com.soavedev.domain.exception.InsufficientBalanceException;
import com.soavedev.domain.response.ErrorResponse;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class InsuficcientBalanceExceptionMapper implements ExceptionMapper<InsufficientBalanceException> {

    @Override
    public Response toResponse(InsufficientBalanceException e) {
        return Response.status(422)
                .entity(new ErrorResponse(
                        422,
                        "Saldo insuficiente")
                )
                .build();
    }
}
