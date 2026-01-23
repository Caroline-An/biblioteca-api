package gov.caixa.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_editoras")
public class Editora {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "CNPJ", nullable = false, unique = true)
    private String cnpj;

    @Column(name = "ENDEREÇO", nullable = false)
    private String endereco;

    @Column(name = "TELEFONE", nullable = false)
    private String telefone;

    @Column(name = "EMAIL", nullable = false)
    private String email;

}
