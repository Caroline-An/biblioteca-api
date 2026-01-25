
package gov.caixa.service;

import gov.caixa.entity.Cliente;
import gov.caixa.entity.Emprestimo;
import gov.caixa.entity.Livro;
import gov.caixa.mapper.EmprestimoMapper;
import gov.caixa.repository.ClienteRepository;
import gov.caixa.repository.EmprestimoRepository;
import gov.caixa.repository.LivroRepository;
import gov.caixa.resource.dto.request.EmprestimoRequest;
import gov.caixa.resource.dto.response.EmprestimoResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final LivroRepository livroRepository;
    private final ClienteRepository clienteRepository;

    public List<EmprestimoResponse> findAll() {
        List<Emprestimo> emprestimos = emprestimoRepository.findAll().list();
        return emprestimos.stream()
                .map(EmprestimoMapper::toResponse)
                .toList();
    }

    public EmprestimoResponse findById(Long id) {
        Emprestimo emprestimo = emprestimoRepository.findById(id);
        return EmprestimoMapper.toResponse(emprestimo);
    }

    @Transactional
    public EmprestimoResponse save(EmprestimoRequest request) {
        if (request == null) throw new BadRequestException("Payload inválido.");

        // Buscar entidades por ID
        Livro livro = livroRepository.findById(request.getLivroId());
        if (livro == null) {
            throw new NotFoundException("Livro não encontrado para o ID: " + request.getLivroId());
        }

        Cliente cliente = clienteRepository.findById(request.getClienteId());
        if (cliente == null) {
            throw new NotFoundException("Cliente não encontrado para o ID: " + request.getClienteId());
        }

        // Converter e validar data prevista de devolução
        LocalDate hoje = LocalDate.now();
        LocalDate dataPrevista;
        try {
            dataPrevista = LocalDate.parse(request.getDataPrevistaDevolucao(), DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (DateTimeParseException e) {
            throw new BadRequestException("Data de devolução inválida. Utilize o formato yyyy-MM-dd.");
        }

        if (!dataPrevista.isAfter(hoje)) {
            throw new BadRequestException("A data de devolução deve ser posterior à data do empréstimo (hoje).");
        }

        Emprestimo emprestimo = EmprestimoMapper.toEntity(livro, cliente);
        emprestimo.setDataEmprestimo(hoje);
        emprestimo.setDataPrevistaDevolucao(dataPrevista);
        emprestimo.setDevolvido(false);

        emprestimoRepository.persistAndFlush(emprestimo);
        return EmprestimoMapper.toResponse(emprestimo);
    }


    @Transactional
    public void update(Long id, @Valid EmprestimoRequest dto) {
        Emprestimo emprestimo = emprestimoRepository.findById(id);
        if (emprestimo == null) {
            throw new NotFoundException("Empréstimo não encontrado");
        }

        // Atualizar livro (opcional)
        if (dto.getLivroId() != null) {
            Livro livro = livroRepository.findById(dto.getLivroId());
            if (livro == null) throw new NotFoundException("Livro não encontrado para id: " + dto.getLivroId());
            emprestimo.setLivro(livro);
        }

        // Atualizar cliente (opcional)
        if (dto.getClienteId() != null) {
            Cliente cliente = clienteRepository.findById(dto.getClienteId());
            if (cliente == null) throw new NotFoundException("Cliente não encontrado para id: " + dto.getClienteId());
            emprestimo.setCliente(cliente);
        }

        // Atualizar data prevista de devolução (obrigatória na sua regra)
        if (dto.getDataPrevistaDevolucao() != null && !dto.getDataPrevistaDevolucao().isBlank()) {
            LocalDate hoje = LocalDate.now();
            LocalDate novaData;
            try {
                novaData = LocalDate.parse(dto.getDataPrevistaDevolucao(), DateTimeFormatter.ISO_LOCAL_DATE);
            } catch (DateTimeParseException e) {
                throw new BadRequestException("Data de devolução inválida. Use yyyy-MM-dd.");
            }

            if (!novaData.isAfter(hoje)) {
                throw new BadRequestException("A data de devolução deve ser posterior a hoje.");
            }

            emprestimo.setDataPrevistaDevolucao(novaData);
        }
        // @Transactional faz flush automático
    }

    @Transactional
    public boolean delete(Long id) {
        // segue o padrão do ClienteService.deleteById
        return emprestimoRepository.deleteById(id);
    }

}
