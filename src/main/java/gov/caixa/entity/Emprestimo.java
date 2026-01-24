package gov.caixa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_emprestimos")
public class Emprestimo {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "LIVRO", referencedColumnName = "ID", nullable = false)
    private Livro livro;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENTE", nullable = false)
    private Cliente cliente;

    @Column(name = "DATA DO EMPRÉSTIMO", nullable = false)
    private LocalDate dataEmprestimo;

    @Column(name = "DATA DA DEVOLUÇÃO", nullable = false)
    private LocalDate dataPrevistaDevolucao;

    @Column(name = "STATUS DE DEVOLVIDO", nullable = false)
    private Boolean devolvido;

}
