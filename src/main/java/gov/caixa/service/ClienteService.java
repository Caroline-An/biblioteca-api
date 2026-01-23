package gov.caixa.service;

import gov.caixa.entity.Cliente;
import gov.caixa.mapper.ClienteMapper;
import gov.caixa.repository.ClienteRepository;
import gov.caixa.resource.dto.request.ClienteRequest;
import gov.caixa.resource.dto.response.ClienteResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public List<ClienteResponse> findAll() {
        List<Cliente> clientes = clienteRepository.findAll().list();
        return clientes.stream()
                .map(ClienteMapper::toResponse)
                .toList();
    }

    public ClienteResponse findById(Long id){
        Cliente cliente = clienteRepository.findById(id);
        return ClienteMapper.toResponse(cliente);
    }

    @Transactional
    public ClienteResponse save(ClienteRequest request) {
        Cliente cliente = ClienteMapper.toEntity(request);
        clienteRepository.persistAndFlush(cliente);
        return ClienteMapper.toResponse(cliente);
    }

    @Transactional
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    @Transactional
    public void update(Long id, @Valid ClienteRequest dto) {
        Cliente cliente = clienteRepository.findById(id);
        cliente.setNome(dto.getNome());
        cliente.setCpf(dto.getCpf());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefone(dto.getTelefone());
        clienteRepository.persist(cliente);
    }


}
