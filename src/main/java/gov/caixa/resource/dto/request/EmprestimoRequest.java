package gov.caixa.resource.dto.request;

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
    private int id;

    @NotNull
    private Livro livro;

    @NotNull
    private LocalDate dataEmprestimo;

    @NotNull
    private LocalDate dataPrevisaDevolucao;

    @NotNull
    private boolean devolvido;
}
