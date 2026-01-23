package gov.caixa.service;

import gov.caixa.entity.Categoria;
import gov.caixa.entity.Editora;
import gov.caixa.entity.Livro;
import gov.caixa.repository.LivroRepository;
import gov.caixa.resource.dto.request.LivroRequest;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.NoSuchElementException;

import static gov.caixa.mapper.LivroMapper.toEntity;

@RequiredArgsConstructor
public class LivroService {
    private final LivroRepository livroRepository;

    public List<Livro> listAll() {
        return livroRepository.listAll();
    }

    public Livro findById(long isbn) {
        return livroRepository.findById(isbn);
    }

    public Livro create(LivroRequest request) {
        Livro livro = toEntity(request);
        livroRepository.persist(livro);
        return livro;
    }

    public void update(LivroRequest request, long isbn) {
        Livro livro = livroRepository.findById(isbn);

        if (livro == null) {
            throw new NoSuchElementException("Livro não encontrado");
        }

        if (!request.title().isBlank()) {
            livro.setTitle(request.title());
        }

        if (request.numeroDePaginas() != null) {
            livro.setNumeroDePaginas(request.numeroDePaginas());
        }

        if (request.anoPublicacao() != null) {
            //TODO: validar ano de publicação
            livro.setAnoPublicacao(request.anoPublicacao());
        }

        if (request.categoriaId() != null) {
            var novaCategoria = Categoria.porId(request.categoriaId());

            if (novaCategoria == null) {
                throw new NoSuchElementException("Categoria não encontrada");
            }

            livro.setCategoria(novaCategoria);

        }

        if(request.editoraId() != null){
            livro.setEditora(Editora.builder().id(Long.valueOf(request.editoraId())).build());
        }

        livroRepository.persist(livro);
    }
}
