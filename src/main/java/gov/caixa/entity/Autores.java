package gov.caixa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Null;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("AUTOR")
public class Autores extends Pessoas {
    @Column(nullable = false, name = "NACIONALIDADE")
    private String nacionalidade;


}
