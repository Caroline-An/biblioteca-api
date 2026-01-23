package gov.caixa.mapper;

import gov.caixa.entity.Livro;
import gov.caixa.resource.dto.request.LivroRequest;
import gov.caixa.resource.dto.response.LivroResponse;

public class LivroMapper {

    public static Livro toEntity(LivroRequest dto) {
        if (dto == null) {
            return null;
        }
        Livro livro = new Livro();
        livro.setIsbn(dto.getIsbn());
        livro.setTitle(dto.getTitle());
        livro.setNumeroDePaginas(dto.getNumeroDePaginas());
        livro.setAnoPublicacao(dto.getAnoPublicacao());
        livro.setCategoria(dto.getCategoria());
        livro.setEditora(dto.getEditora());
        return livro;
    }

    public static LivroResponse toResponse(Livro entity) {
        if (entity == null) {
            return null;
        }
        return LivroResponse.builder()
                .isbn(entity.getIsbn())
                .title(entity.getTitle())
                .numeroDePaginas(entity.getNumeroDePaginas())
                .anoPublicacao(entity.getAnoPublicacao())
                .categoria(entity.getCategoria())
                .editora(entity.getEditora())
                .build();
    }
}
