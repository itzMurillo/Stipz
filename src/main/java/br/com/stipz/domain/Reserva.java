package br.com.stipz.domain;

import br.com.stipz.enums.StatusReserva;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "reserva")
@Getter @Setter
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_sala")
    private Sala sala;

    @ManyToOne
    @JoinColumn(name = "id_evento")
    private Evento evento;

    @Column(nullable = false)
    private LocalDateTime dataInicio;

    @Column(nullable = false)
    private LocalDateTime dataFim;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusReserva status;

    @Column(nullable = false)
    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;
}
