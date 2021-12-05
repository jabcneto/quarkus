package com.jabcneto.resource;

import com.jabcneto.model.dto.CartaDTO;
import com.jabcneto.service.CartaService;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Slf4j
@Path("/carta")
public class CartaResource {

    @Inject
    CartaService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscaTodas() {
        return Response.ok(service.buscaTodas()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscaUma(@PathParam("id") Long id) {
        return Response.ok(service.buscaUmaPorId(id)).build();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastraCarta(@Valid CartaDTO dto) {
        service.cadastra(dto);
        return Response.created(null).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deletaCarta(@PathParam("id") Long id) {
        service.deletarPeloId(id);
        return Response.accepted().build();
    }

}
