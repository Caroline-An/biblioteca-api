
package gov.caixa.mapper;

import gov.caixa.entity.Cliente;
import gov.caixa.entity.Emprestimo;
import gov.caixa.entity.Livro;
import gov.caixa.resource.dto.response.EmprestimoResponse;
import lombok.Data;

@Data
public class EmprestimoMapper {

    public static Emprestimo toEntity(Livro livro, Cliente cliente) {
        Emprestimo e = new Emprestimo();
        e.setLivro(livro);
        e.setCliente(cliente);
        return e;
    }

    public static EmprestimoResponse toResponse(Emprestimo emprestimo) {
        if (emprestimo == null) return null;

        return EmprestimoResponse.builder()
                .id(emprestimo.getId())
                .livroId(emprestimo.getLivro() != null ? emprestimo.getLivro().getId() : null)
                .clienteId(emprestimo.getCliente() != null ? emprestimo.getCliente().getId() : null)
                .dataEmprestimo(emprestimo.getDataEmprestimo())
                .dataPrevistaDevolucao(emprestimo.getDataPrevistaDevolucao())
                .devolvido(emprestimo.getDevolvido())
                .build();
    }
}
