package gov.caixa.resource.dto.request;


import gov.caixa.entity.Categorias;
import gov.caixa.entity.Editoras;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LivroRequest {
    @NotBlank(message = "O campo ISBN não pode ser blank!")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int isbn;

    @NotNull
    private String title;

    @NotNull
    private int numeroDePaginas;

    @NotNull
    private int anoPublicacao;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORIA", nullable = false, length = 30)
    private Categorias categoria;

    @NotNull
    @Column(name = "EDITORA")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "editora_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_livro_editora"))
    private Editoras editora;
}
