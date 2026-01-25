
package gov.caixa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_emprestimo") // opcional: padronizar singular como em tbl_cliente
public class Emprestimo {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // padronizado para Long

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "LIVRO_ID", referencedColumnName = "ID", nullable = false)
    private Livro livro;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENTE_ID", referencedColumnName = "ID", nullable = false)
    private Cliente cliente;

    @Column(name = "DATA_EMPRESTIMO", nullable = false)
    private LocalDate dataEmprestimo;

    @Column(name = "DATA_PREVISTA_DEVOLUCAO", nullable = false)
    private LocalDate dataPrevistaDevolucao;

    @Column(name = "DEVOLVIDO", nullable = false)
    private Boolean devolvido;
}
