package gov.caixa.resource.dto.request;

import gov.caixa.entity.Editora;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LivroRequest(
        @NotBlank(message = "O campo ISBN não pode ser blank!")
        int isbn,

        @NotNull
        String title,

        @NotNull
        Integer numeroDePaginas,

        @NotNull
        Integer anoPublicacao,

        @NotNull
        Integer categoriaId,

        @NotNull
        Integer editoraId) {
}
