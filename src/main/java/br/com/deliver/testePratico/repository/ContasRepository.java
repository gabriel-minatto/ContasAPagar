package br.com.deliver.testePratico.repository;

import br.com.deliver.testePratico.model.Contas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContasRepository extends JpaRepository<Contas, Long> {
}
