package br.com.stipz.repository;

import br.com.stipz.domain.Reserva;
import br.com.stipz.domain.Sala;
import br.com.stipz.domain.Usuario;
import br.com.stipz.enums.StatusReserva;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    boolean existsBySalaAndDataInicioLessThanAndDataFimGreaterThanAndStatusNot(
            Sala sala,
            LocalDateTime fim,
            LocalDateTime inicio,
            StatusReserva status
    );

    long countByUsuarioAndDataInicioBetween(
            Usuario usuario,
            LocalDateTime inicio,
            LocalDateTime fim
    );

    List<Reserva> findBySalaId(Long salaId);

    List<Reserva> findByUsuarioId(Long usuarioId);

}
