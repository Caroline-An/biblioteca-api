
package gov.caixa.resource.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EditoraRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String cnpj;

    @NotBlank
    private String endereco;

    @NotBlank
    private String telefone;

    @NotBlank
    private String email;
}
