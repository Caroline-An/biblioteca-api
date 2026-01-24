package gov.caixa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "tbl_livros",
        uniqueConstraints = @UniqueConstraint(name = "uk_livro_isbn", columnNames = "isbn"))

public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ISBN", nullable = false, length = 13)
    @Size(min = 10, max = 13, message = "ISBN deve ter entre e 13 caracteres")
    @Pattern(regexp = "^[0-9Xx-]+$", message = "ISBN deve conter dígitos, hífens e opcionalmente X")
    private String isbn;

    @Column(name = "TÍTULO", nullable = false)
    private String title;

    @Column(name = "NUMERO_DE_PAGINAS", nullable = false)
    private Integer numeroDePaginas;

    @Column(name = "ANO_DE_PUBLICACAO", nullable = false)
    private Integer anoPublicacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORIA", nullable = false, length = 30)
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "EDITORA_ID",
            referencedColumnName = "ID",
            nullable = false)
    private Editora editora;

}
