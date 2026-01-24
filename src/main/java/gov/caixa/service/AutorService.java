package gov.caixa.service;

import gov.caixa.entity.Autor;
import gov.caixa.mapper.AutorMapper;
import gov.caixa.repository.AutorRepository;
import gov.caixa.resource.dto.request.AutorRequest;
import gov.caixa.resource.dto.response.AutorResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class AutorService {

    private final AutorRepository autorRepository;

    public List<AutorResponse> findAll() {
        List<Autor> autores = autorRepository.findAll().list();
        return autores.stream()
                .map(AutorMapper::toResponse)
                .toList();
    }

    public AutorResponse findById(Long id){
        Autor autor = autorRepository.findById(id);
        return AutorMapper.toResponse(autor);
    }

    @Transactional
    public AutorResponse save(AutorRequest request) {
        Autor autor = AutorMapper.toEntity(request);
        autorRepository.persistAndFlush(autor);
        return AutorMapper.toResponse(autor);
    }

    @Transactional
    public void delete(Long id) {
        autorRepository.deleteById(id);
    }

    @Transactional
    public void update(Long id, @Valid AutorRequest dto) {
        Autor autor = autorRepository.findById(id);
        autor.setNome(dto.getNome());
        autor.setNacionalidade(dto.getNacionalidade());
        autorRepository.persist(autor);
    }
}
