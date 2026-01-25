
package gov.caixa.resource;

import gov.caixa.mapper.LivroMapper;
import gov.caixa.resource.dto.request.LivroRequest;
import gov.caixa.service.LivroService;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

@Path("livros")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class LivroResource {

    private final LivroService livroService;

    @GET
    public Response findAll() {
        var body = livroService.listAll()
                .stream()
                .map(LivroMapper::toResponse)
                .toList();
        return Response.ok(body).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") long id) {
        var livro = livroService.findById(id);
        if (livro == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(LivroMapper.toResponse(livro)).build();
    }


    @POST
    public Response create(@Valid LivroRequest request) {
        var created = livroService.create(request);
        return Response.status(Response.Status.CREATED)
                .entity(LivroMapper.toResponse(created))
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") long id, @Valid LivroRequest request) {
        livroService.update(request, id);
        return Response.noContent().build();
    }

}
