
package gov.caixa.mapper;

import gov.caixa.entity.Categoria;
import gov.caixa.entity.Editora;
import gov.caixa.entity.Livro;
import gov.caixa.resource.dto.request.LivroRequest;
import gov.caixa.resource.dto.response.LivroResponse;

public class LivroMapper {

    public static Livro toEntity(LivroRequest dto) {
        if (dto == null) return null;

        Livro livro = new Livro();
        livro.setIsbn(dto.getIsbn());
        livro.setTitle(dto.getTitle());
        livro.setNumeroDePaginas(dto.getNumeroDePaginas());
        livro.setAnoPublicacao(dto.getAnoPublicacao());

        // categoriaId -> Categoria
        if (dto.getCategoriaId() == null) {
            throw new IllegalArgumentException("categoriaId é obrigatório");
        }
        var categoria = Categoria.porId(dto.getCategoriaId());
        if (categoria == null) {
            throw new IllegalArgumentException("Categoria inválida: " + dto.getCategoriaId());
        }
        livro.setCategoria(categoria);

        // editoraId -> referência Editora
        if (dto.getEditoraId() == null) {
            throw new IllegalArgumentException("editoraId é obrigatório");
        }
        Editora ref = new Editora();
        ref.setId(dto.getEditoraId());
        livro.setEditora(ref);

        return livro;
    }

    public static LivroResponse toResponse(Livro entity) {
        if (entity == null) return null;

        return LivroResponse.builder()
                .id(entity.getId())
                .isbn(entity.getIsbn())
                .title(entity.getTitle())
                .numeroDePaginas(entity.getNumeroDePaginas())
                .anoPublicacao(entity.getAnoPublicacao())
                .categoria(entity.getCategoria())
                .editora(entity.getEditora())
                .build();
    }
}
