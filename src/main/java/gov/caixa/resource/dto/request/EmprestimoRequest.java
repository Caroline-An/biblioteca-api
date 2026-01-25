
package gov.caixa.resource.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmprestimoRequest {

    @NotNull
    private Long livroId;

    @NotNull
    private Long clienteId;

    @NotBlank
    private String dataPrevistaDevolucao;
}
