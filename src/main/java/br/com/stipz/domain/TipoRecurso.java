package br.com.stipz.domain;

import br.com.stipz.enums.CategoriaRecurso;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tipo_recurso")
@Getter
@Setter
public class TipoRecurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoriaRecurso categoria;

    @Column(nullable = false)
    private Boolean permitido;

    @Column(nullable = false)
    private Boolean exigeAprovacao;
}
