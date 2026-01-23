package gov.caixa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_autor")
@DiscriminatorValue("AUTOR")
public class Autor extends Pessoa {
    @Column(nullable = false, name = "NACIONALIDADE")
    private String nacionalidade;


}
