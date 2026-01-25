
package gov.caixa.resource.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LivroRequest {

        @NotBlank(message = "O campo ISBN não pode ser blank!")
        @Size(min = 10, max = 17, message = "ISBN deve ter entre 10 e 17 caracteres (com hífens)")
        @Pattern(regexp = "^[0-9Xx-]+$", message = "ISBN deve conter dígitos, hífens e opcionalmente X")
        private String isbn;

        @NotBlank(message = "O título é obrigatório")
        private String title;

        @NotNull @Min(1)
        private Integer numeroDePaginas;

        @NotNull
        private Integer anoPublicacao;

        @NotNull
        private Integer categoriaId;

        @NotNull
        private Long editoraId;
}
