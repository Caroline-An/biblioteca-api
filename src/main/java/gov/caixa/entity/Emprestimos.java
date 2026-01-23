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

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "LIVRO", referencedColumnName = "ID", nullable = false)
    private Livros livros;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENTE", nullable = false)
    private Clientes clientes;

    @Column(name = "DATA DO EMPRÉSTIMO", nullable = false)
    private LocalDate dataEmprestimo;

    @Column(name = "DATA DA DEVOLUÇÃO", nullable = false)
    private LocalDate dataPrevistaDevolucao;

    @Column(name = "STATUS DE DEVOLVIDO", nullable = false)
    private boolean devolvido;
}
