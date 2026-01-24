package gov.caixa.resource;


import gov.caixa.entity.Categoria;
import gov.caixa.resource.dto.response.CategoriaOption;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Arrays;
import java.util.List;

@Path("categorias")
public class CategoriaResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        List<CategoriaOption> options = Arrays.stream(Categoria.values())
                .map(c -> new CategoriaOption(c.getId(), c.name()))
                .toList();

        return Response.ok(options).build();
    }
}
