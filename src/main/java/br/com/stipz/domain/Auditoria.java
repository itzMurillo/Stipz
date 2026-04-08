package br.com.stipz.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "auditoria")
@Getter
@Setter
public class Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    private String entidade;
    private Long idEntidade;
    private String acao;
    private LocalDateTime dataExecucao;
}
