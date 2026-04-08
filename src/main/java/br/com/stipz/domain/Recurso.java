package br.com.stipz.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "recurso")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer quantidade;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_tipo_recurso")
    private TipoRecurso tipoRecurso;

    @ManyToOne
    @JoinColumn(name = "id_sala")
    private Sala sala;

    @Column(nullable = false)
    private Boolean fixo;
}
