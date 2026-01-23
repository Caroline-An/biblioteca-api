package gov.caixa.resource.dto.request;

import gov.caixa.entity.Livro;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

public record EmprestimoRequest(
        @NotNull
        int id,

        @NotNull
        Livro livro,

        @NotNull
        LocalDate dataEmprestimo,

        @NotNull
        LocalDate dataPrevisaDevolucao,

        @NotNull
        boolean devolvido) {
}
