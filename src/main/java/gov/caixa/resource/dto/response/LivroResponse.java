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
    private int isbn;
    private String title;
    private int numeroDePaginas;
    private int anoPublicacao;
    private Categoria categoria;
    private Editora editora;

}
