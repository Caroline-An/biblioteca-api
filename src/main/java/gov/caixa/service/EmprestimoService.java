package gov.caixa.service;

import gov.caixa.entity.Emprestimo;
import gov.caixa.mapper.EmprestimoMapper;
import gov.caixa.repository.EmprestimoRepository;
import gov.caixa.resource.dto.request.EmprestimoRequest;
import gov.caixa.resource.dto.response.EmprestimoResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.BadRequestException;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class EmprestimoService {
    private final EmprestimoRepository emprestimoRepository;

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
        LocalDate hoje = LocalDate.now();

        if (request.getDataPrevistaDevolucao() == null) {
            throw new BadRequestException("A data de devolução é obrigatória.");
        }
        if (!request.getDataPrevistaDevolucao().isAfter(hoje)) {
            throw new BadRequestException("A data de devolução deve ser posterior à data do empréstimo (hoje).");
        }

        Emprestimo emprestimo = EmprestimoMapper.toEntity(request);
        emprestimo.setDataEmprestimo(hoje);
        emprestimo.setDevolvido(false); // novo empréstimo sempre começa como não devolvido
        emprestimoRepository.persistAndFlush(emprestimo);
        return EmprestimoMapper.toResponse(emprestimo);
    }
}
