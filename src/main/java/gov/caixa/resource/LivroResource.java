package gov.caixa.resource;

import gov.caixa.mapper.LivroMapper;
import gov.caixa.resource.dto.request.LivroRequest;
import gov.caixa.resource.dto.response.LivroResponse;
import gov.caixa.service.LivroService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

import static gov.caixa.mapper.LivroMapper.toEntity;
import static gov.caixa.mapper.LivroMapper.toResponse;

@Path("livros")
@RequiredArgsConstructor
public class LivroResource {

    private final LivroService livroService;

    @GET
    public Response findAll() {
        return Response.ok(livroService.listAll().stream().map(LivroMapper::toResponse)).build();
    }

    @GET
    @Path("/{isbn}")
    public Response findById(@PathParam("isbn") long isbn) {
        var livro = livroService.findById(isbn);

        if (livro == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(toResponse(livro)).build();
    }

    @POST
    public Response create(LivroRequest request) {
        return Response.ok(livroService.create(request)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("isbn") long isbn, LivroRequest request) {
        livroService.update(toEntity(request, isbn));
        return Response.noContent().build();
    }
}
