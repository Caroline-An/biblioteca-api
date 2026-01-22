package gov.caixa.repository;

import gov.caixa.entity.Pessoas;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PessoasRepository implements PanacheRepository<Pessoas> {
}
