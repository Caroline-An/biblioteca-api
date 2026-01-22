package gov.caixa.entity;

import biblioteca.entity.Categorias;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Livros {
    @Id
    @Size(max = 20)
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int isbn;

    @Column(name = "TÍTULO", nullable = false)
    private String titulo;

    @Column(name = "NÚMERO DE PÁGINAS", nullable = false)
    private int numeroDePaginas;

    @Column(name = "ANO DE PUBLICAÇÃO", nullable = false)
    private int anoPublicacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORIA", nullable = false, length = 30)
    private Categorias categoria;

    @Column(name = "EDITORA")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "editora_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_livro_editora"))
    private Editoras editora;

}
