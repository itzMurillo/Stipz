package br.com.stipz.repository;

import br.com.stipz.domain.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SalaRepository extends JpaRepository<Sala, Long> {

    Optional<Sala> findByNome(String nome);
}
