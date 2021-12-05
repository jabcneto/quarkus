package com.jabcneto.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionHandler implements ExceptionMapper<Exception>
{
    @Override
    public Response toResponse(Exception exception)
    {
        ExceptionResponse build = ExceptionResponse.builder().message(exception.getMessage()).code(Status.BAD_REQUEST.getStatusCode()).build();
        return Response.status(Status.BAD_REQUEST).entity(build).build();
    }
}