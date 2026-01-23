package gov.caixa.repository;

import gov.caixa.entity.Livro;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface LivroRepository extends PanacheRepository<Livro> {
}
