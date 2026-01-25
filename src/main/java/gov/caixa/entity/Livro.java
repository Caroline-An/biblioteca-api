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
@Table(
        name = "tbl_livros",
        uniqueConstraints = @UniqueConstraint(name = "uk_livro_isbn", columnNames = "ISBN")
)
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ISBN", nullable = false, length = 17) // aumentar para 17
    @Size(min = 10, max = 17, message = "ISBN deve ter entre 10 e 17 caracteres (com hífens)")
    @Pattern(regexp = "^[0-9Xx-]+$", message = "ISBN deve conter dígitos, hífens e opcionalmente X")
    private String isbn;


    @Column(name = "TITULO", nullable = false) // sem acento
    private String title;

    @Column(name = "NUMERO_DE_PAGINAS", nullable = false)
    private Integer numeroDePaginas;

    @Column(name = "ANO_DE_PUBLICACAO", nullable = false)
    private Integer anoPublicacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORIA", nullable = false, length = 30)
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "EDITORA_ID", referencedColumnName = "ID", nullable = false)
    private Editora editora;
}

