
package gov.caixa.resource;

import gov.caixa.resource.dto.request.EditoraRequest;
import gov.caixa.service.EditoraService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.jboss.logging.Logger;

@Path("/editoras")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class EditoraResource {

    private final EditoraService editoraService;

    @Inject
    Logger log;

    @GET
    public Response findAll() {
        var editoras = editoraService.findAll();
        return Response.ok(editoras).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        var editora = editoraService.findById(id);
        if (editora == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(editora).build();
        }
    }

    @POST
    public Response save(@Valid EditoraRequest dto) {
        log.info(dto);
        var response = editoraService.save(dto);
        return Response
                .status(Response.Status.CREATED)
                .entity(response)
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        editoraService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, @Valid EditoraRequest dto) {
        log.info(dto);
        var editora = editoraService.findById(id);
        if (editora == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        editoraService.update(id, dto);
        return Response.ok().build();
    }
}
