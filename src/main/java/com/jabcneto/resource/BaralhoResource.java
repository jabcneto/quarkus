package com.jabcneto.resource;

import com.jabcneto.model.Baralho;
import com.jabcneto.model.dto.BaralhoDTO;
import com.jabcneto.service.BaralhoService;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Slf4j
@Path("/baralho")
public class BaralhoResource {

    @Inject
    BaralhoService service;

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
    public Response cadastra(@Valid BaralhoDTO dto) {
        service.cadastra(dto);
        return Response.created(null).build();
    }

    @PUT
    @Transactional
    @Path("/{baralho-id}/{carta-id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response adicionaCarta(@Valid @PathParam("baralho-id") Long baralhoId, @PathParam("carta-id") Long cartaId) {
        Baralho baralho = service.adicionaCarta(baralhoId, cartaId);
        return Response.ok(baralho).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deleta(@PathParam("id") Long id) {
        service.deletarPeloId(id);
        return Response.accepted().build();
    }

}
