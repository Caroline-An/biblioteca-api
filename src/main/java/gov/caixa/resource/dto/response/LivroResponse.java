package gov.caixa.resource.dto.response;

import gov.caixa.entity.Categorias;
import gov.caixa.entity.Editoras;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
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
    private Categorias categoria;
    private Editoras editora;

}
