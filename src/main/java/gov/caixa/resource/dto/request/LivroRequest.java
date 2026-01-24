
package gov.caixa.resource.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LivroRequest {

        @NotBlank(message = "O campo ISBN não pode ser blank!")
        @Size(min = 10, max = 13, message = "ISBN deve ter entre 10 a 13 caracateres")
        @Pattern(regexp = "^[0-9Xx-]+$", message = "ISBN deve conter dígitos, hífens e opcionalmente X")
        private String isbn;

        @NotBlank(message = "O título é obrigatório")
        private String title;

        @NotNull @Min(1)
        private Integer numeroDePaginas;

        @NotNull
        private Integer anoPublicacao;

        @NotNull
        private Integer categoriaId; // ✅ volta a ser ID

        @NotNull
        private Long editoraId;      // ✅ volta a ser ID
}
