package gov.caixa.service;

import gov.caixa.entity.Autores;
import gov.caixa.mapper.AutoresMapper;
import gov.caixa.repository.AutoresRepository;
import gov.caixa.resource.dto.request.AutorRequest;
import gov.caixa.resource.dto.response.AutorResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class AutoresService {

    private final AutoresRepository autoresRepository;

    public List<AutorResponse> findAll() {
        List<Autores> autores = autoresRepository.findAll().list();
        return autores.stream()
                .map(AutoresMapper::toResponse)
                .toList();
    }

    public AutorResponse findById(Long id){
        Autores autores = autoresRepository.findById(id);
        return AutoresMapper.toResponse(autores);
    }

    @Transactional
    public AutorResponse save(AutorRequest request) {
        Autores autores = AutoresMapper.toEntity(request);
        autoresRepository.persistAndFlush(autores);
        return AutoresMapper.toResponse(autores);
    }
}
