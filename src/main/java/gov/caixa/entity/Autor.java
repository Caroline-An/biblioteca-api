package gov.caixa.entity;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_autor")
@DiscriminatorValue("AUTOR")
@PrimaryKeyJoinColumn(name = "ID")
public class Autor extends Pessoa {
    @Column(nullable = false, name = "NACIONALIDADE")
    private String nacionalidade;


}
