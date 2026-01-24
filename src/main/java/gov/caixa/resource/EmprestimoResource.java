package gov.caixa.resource;

import gov.caixa.resource.dto.request.EmprestimoRequest;
import gov.caixa.service.EmprestimoService;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.jboss.logging.Logger;
import jakarta.inject.Inject;

@Path("/emprestimos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class EmprestimoResource {
    private final EmprestimoService emprestimoService;

    @Inject
    Logger log;

    @GET
    public Response findAll(){
        var emprestimos = emprestimoService.findAll();
        return Response.ok(emprestimos).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id){
        var emprestimo = emprestimoService.findById(id);
        if (emprestimo == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }else {
            return Response.ok(emprestimo).build();
        }

    }

    //a data do emprestimo e de devolução é informada pelo cliente em formato string, daí transforma para localdate e valida se é uma data válida ou não
    @POST
    public Response save(@Valid EmprestimoRequest dto){
        log.info(String.valueOf(dto));
        var response = emprestimoService.save(dto);
        return Response
                .status(Response.Status.CREATED)
                .entity(response)
                .build();
    }
}
