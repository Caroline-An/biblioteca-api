package gov.caixa.resource.dto.response;

import gov.caixa.entity.Categoria;
import gov.caixa.entity.Editora;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LivroResponse {
    private Long id;
    private String isbn;
    private String title;
    private Integer numeroDePaginas;
    private Integer anoPublicacao;
    private Categoria categoria;
    private Editora editora;

}
