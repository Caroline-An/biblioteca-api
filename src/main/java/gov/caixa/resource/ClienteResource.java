package gov.caixa.resource;

import gov.caixa.resource.dto.request.ClienteRequest;
import gov.caixa.service.ClienteService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.jboss.logging.Logger;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class ClienteResource {
    private final ClienteService clienteService;

    @Inject
    Logger log;

    @GET
    public Response findAll(){
        var clientes = clienteService.findAll();
        return Response.ok(clientes).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        var cliente = clienteService.findById(id);
        if (cliente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(cliente).build();
        }
    }

    @POST
    public Response save(@Valid ClienteRequest dto) {
        log.info(dto);
        var response = clienteService.save(dto);
        return Response
                .status(Response.Status.CREATED)
                .entity(response)
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        clienteService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, @Valid ClienteRequest dto) {
        log.info(dto);
        var cliente = clienteService.findById(id);
        if (cliente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        clienteService.update(id, dto);
        return Response.ok().build();
    }
}
