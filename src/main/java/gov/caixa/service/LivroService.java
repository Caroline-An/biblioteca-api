
package gov.caixa.service;

import gov.caixa.entity.Categoria;
import gov.caixa.entity.Editora;
import gov.caixa.entity.Livro;
import gov.caixa.repository.LivroRepository;
import gov.caixa.resource.dto.request.LivroRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@ApplicationScoped
public class LivroService {

    @Inject
    LivroRepository livroRepository;

    public List<Livro> listAll() {
        return livroRepository.listAll();
    }

    public Livro findById(long id) {
        return livroRepository.findById(id);
    }

    @Transactional
    public Livro create(LivroRequest request) {
        var categoria = Categoria.porId(request.getCategoriaId());
        if (categoria == null) {
            throw new NoSuchElementException("Categoria não encontrada");
        }

        Editora editora = new Editora();
        editora.setId(request.getEditoraId());

        Livro livro = new Livro();
        livro.setIsbn(request.getIsbn());
        livro.setTitle(request.getTitle());
        livro.setNumeroDePaginas(request.getNumeroDePaginas());
        livro.setAnoPublicacao(request.getAnoPublicacao());
        livro.setCategoria(categoria);
        livro.setEditora(editora);

        livroRepository.persist(livro);
        return livro;
    }

    @Transactional
    public void update(LivroRequest request, long id) {
        Livro livro = livroRepository.findById(id);
        if (livro == null) throw new NoSuchElementException("Livro não encontrado");

        if (request.getTitle() != null && !request.getTitle().isBlank()) {
            livro.setTitle(request.getTitle());
        }
        if (request.getNumeroDePaginas() != null) {
            livro.setNumeroDePaginas(request.getNumeroDePaginas());
        }
        if (request.getAnoPublicacao() != null) {
            livro.setAnoPublicacao(request.getAnoPublicacao());
        }
        if (request.getCategoriaId() != null) {
            var nova = Categoria.porId(request.getCategoriaId());
            if (nova == null) throw new NoSuchElementException("Categoria não encontrada");
            livro.setCategoria(nova);
        }
        if (request.getEditoraId() != null) {
            Editora e = new Editora();
            e.setId(request.getEditoraId());
            livro.setEditora(e);
        }
        // @Transactional: flush automático
    }
}
