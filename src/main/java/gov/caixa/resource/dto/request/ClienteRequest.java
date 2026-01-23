package gov.caixa.resource.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClienteRequest {

    @NotNull
    private String cpf;

    @NotNull
    private String email;

    @NotNull
    private String telefone;
}
