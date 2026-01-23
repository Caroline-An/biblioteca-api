package gov.caixa.repository;

import gov.caixa.entity.Autores;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AutoresRepository implements PanacheRepository<Autores> {
}
