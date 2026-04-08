package br.com.stipz.repository;

import br.com.stipz.domain.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RecursoRepository extends JpaRepository<Recurso, Long> {
    boolean existsByNomeAndSalaId(String nome, Long salaId);
    List<Recurso> findByNomeContainingIgnoreCase(String nome);
    List<Recurso> findByTipoRecurso_NomeContainingIgnoreCase(String tipo);
}
