package gov.caixa.resource.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AutorRequest {
//    @NotNull
//    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private String nacionalidade;
}
