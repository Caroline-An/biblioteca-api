package gov.caixa.resource;

import gov.caixa.resource.dto.request.AutorRequest;
import gov.caixa.service.AutorService;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

import org.jboss.logging.Logger;
import jakarta.inject.Inject;

@Path("/autores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class AutorResource {
    private final AutorService autorService;

    @Inject
    Logger log;

    @GET
    public Response findAll() {
        var autores = autorService.findAll();
        return Response.ok(autores).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        var autores = autorService.findById(id);
        if (autores == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(autores).build();
        }
    }

    @POST
    public Response save(@Valid AutorRequest dto) {
        log.info(dto);
        var response = autorService.save(dto);
        return Response
                .status(Response.Status.CREATED)
                .entity(response)
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        autorService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, @Valid AutorRequest dto) {
        log.info(dto);
        var autores = autorService.findById(id);
        if (autores == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        autorService.update(id, dto);
        return Response.ok().build();
    }
}
