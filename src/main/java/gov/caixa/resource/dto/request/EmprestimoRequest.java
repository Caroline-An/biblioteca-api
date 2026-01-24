package gov.caixa.resource.dto.request;

import gov.caixa.entity.Cliente;
import gov.caixa.entity.Livro;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmprestimoRequest {

    @NotNull
    private Livro livrowq;

    @NotNull
    private Cliente cliente;

    @NotNull
    Livro livro;

    @NotNull
    private LocalDate dataEmprestimo;

    @NotNull
    private LocalDate dataPrevistaDevolucao;

    @NotNull
    private boolean devolvido;
}
