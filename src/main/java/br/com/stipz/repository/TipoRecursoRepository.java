package br.com.stipz.repository;

import br.com.stipz.domain.TipoRecurso;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface TipoRecursoRepository extends JpaRepository<TipoRecurso, Long> {

    Optional<TipoRecurso> findByNomeIgnoreCase(String nome);
    List<TipoRecurso> findByNomeContainingIgnoreCase(String nome);
}