package gov.caixa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_emprestimos")
public class Emprestimos {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "LIVRO", nullable = false)
    private Livros livro;

    @Column(name = "DATA DO EMPRÉSTIMO", nullable = false)
    private LocalDate dataEmprestimo;

    @Column(name = "DATA DA DEVOLUÇÃO", nullable = false)
    private LocalDate dataPrevistaDevolucao;

    @Column(name = "STATUS DE DEVOLVIDO", nullable = false)
    private boolean devolvido;
}
