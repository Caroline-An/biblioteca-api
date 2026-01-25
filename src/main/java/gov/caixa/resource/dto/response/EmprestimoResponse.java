
package gov.caixa.resource.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmprestimoResponse {
    private Long id;
    private Long livroId;
    private Long clienteId;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private Boolean devolvido;
}
