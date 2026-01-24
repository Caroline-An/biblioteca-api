package gov.caixa.mapper;

import gov.caixa.entity.Emprestimo;
import gov.caixa.resource.EmprestimoResource;
import gov.caixa.resource.dto.request.EmprestimoRequest;
import gov.caixa.resource.dto.response.EmprestimoResponse;
import lombok.Data;

@Data
public class EmprestimoMapper {
    public static Emprestimo toEntity(EmprestimoRequest dto){
        if (dto == null){
            return null;
        }

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setLivro(dto.getLivro());
        emprestimo.setCliente(dto.getCliente());
        emprestimo.setDataEmprestimo(dto.getDataEmprestimo());
        emprestimo.setDataPrevistaDevolucao(dto.getDataPrevistaDevolucao());
        emprestimo.setDevolvido(dto.isDevolvido());
        return emprestimo;
    }

    public static EmprestimoResponse toResponse(Emprestimo emprestimo){
        if (emprestimo == null){
            return null;
        }

        return EmprestimoResponse.builder()
                .id(emprestimo.getId())
                .livro(emprestimo.getLivro())
                .cliente(emprestimo.getCliente())
                .dataEmprestimo(emprestimo.getDataEmprestimo())
                .dataPrevistaDevolucao(emprestimo.getDataPrevistaDevolucao())
                .devolvido(emprestimo.getDevolvido())
                .build();
    }
}
