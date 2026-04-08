package br.com.stipz.repository;

import br.com.stipz.domain.ReservaRecurso;
import br.com.stipz.domain.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaRecursoRepository extends JpaRepository<ReservaRecurso, Long> {

    List<ReservaRecurso> findByRecurso(Recurso recurso);
}