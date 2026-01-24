package gov.caixa.resource.dto.response;

import gov.caixa.entity.Cliente;
import gov.caixa.entity.Livro;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmprestimoResponse {
    private int id;
    private Livro livro;
    private Cliente cliente;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private Boolean devolvido;
}
