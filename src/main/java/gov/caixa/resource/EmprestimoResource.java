
package gov.caixa.resource;

import gov.caixa.resource.dto.request.EmprestimoRequest;
import gov.caixa.service.EmprestimoService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.jboss.logging.Logger;

@Path("/emprestimos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class EmprestimoResource {

    private final EmprestimoService emprestimoService;

    @Inject
    Logger log;

    @GET
    public Response findAll() {
        var emprestimos = emprestimoService.findAll();
        return Response.ok(emprestimos).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        var emprestimo = emprestimoService.findById(id);
        if (emprestimo == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(emprestimo).build();
        }
    }

    // a data de devolução vem como string "yyyy-MM-dd" e é validada e convertida no service
    @POST
    public Response save(@Valid EmprestimoRequest dto) {
        log.info(dto);
        var response = emprestimoService.save(dto);
        return Response
                .status(Response.Status.CREATED)
                .entity(response)
                .build();
    }


    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, @Valid EmprestimoRequest dto) {
        log.info(dto);
        var existente = emprestimoService.findById(id);
        if (existente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        emprestimoService.update(id, dto);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        boolean deleted = emprestimoService.delete(id);
        if (!deleted) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
