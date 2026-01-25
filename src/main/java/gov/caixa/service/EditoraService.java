
package gov.caixa.service;

import gov.caixa.entity.Editora;
import gov.caixa.mapper.EditoraMapper;
import gov.caixa.repository.EditoraRepository;
import gov.caixa.resource.dto.request.EditoraRequest;
import gov.caixa.resource.dto.response.EditoraResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class EditoraService {

    private final EditoraRepository editoraRepository;

    public List<EditoraResponse> findAll() {
        List<Editora> editoras = editoraRepository.findAll().list();
        return editoras.stream()
                .map(EditoraMapper::toResponse)
                .toList();
    }

    public EditoraResponse findById(Long id) {
        Editora editora = editoraRepository.findById(id);
        return EditoraMapper.toResponse(editora);
    }

    @Transactional
    public EditoraResponse save(@Valid EditoraRequest request) {
        Editora editora = EditoraMapper.toEntity(request);
        editoraRepository.persistAndFlush(editora);
        return EditoraMapper.toResponse(editora);
    }

    @Transactional
    public void delete(Long id) {
        editoraRepository.deleteById(id);
    }

    @Transactional
    public void update(Long id, @Valid EditoraRequest dto) {
        Editora editora = editoraRepository.findById(id);
        editora.setNome(dto.getNome());
        editora.setCnpj(dto.getCnpj());
        editora.setEndereco(dto.getEndereco());
        editora.setTelefone(dto.getTelefone());
        editora.setEmail(dto.getEmail());
        editoraRepository.persist(editora);
    }
}
