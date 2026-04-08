package br.com.stipz.service;

import br.com.stipz.domain.Recurso;
import br.com.stipz.domain.Sala;
import br.com.stipz.domain.TipoRecurso;
import br.com.stipz.enums.CategoriaRecurso;
import br.com.stipz.repository.RecursoRepository;
import br.com.stipz.repository.SalaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecursoService {

    private final RecursoRepository recursoRepository;
    private final TipoRecursoService tipoRecursoService;
    private final SalaRepository salaRepository;

    public RecursoService(
            RecursoRepository recursoRepository,
            TipoRecursoService tipoRecursoService,
            SalaRepository salaRepository
    ) {
        this.recursoRepository = recursoRepository;
        this.tipoRecursoService = tipoRecursoService;
        this.salaRepository = salaRepository;
    }

    public Recurso criar(
            String nome,
            String descricao,
            CategoriaRecurso categoria,
            Integer quantidade,
            Long salaId,
            Boolean fixo
    ) {

        if (fixo == null) {
            throw new RuntimeException("Campo 'fixo' é obrigatório");
        }

        if (salaId == null) {
            throw new RuntimeException("Recurso deve estar vinculado a uma sala");
        }

        Sala sala = salaRepository.findById(salaId)
                .orElseThrow(() -> new RuntimeException("Sala não encontrada"));

        TipoRecurso tipoRecurso = tipoRecursoService.buscarOuCriar(descricao, categoria);

        if (Boolean.TRUE.equals(fixo)) {

            boolean exists = recursoRepository.existsByNomeAndSalaId(nome, salaId);

            if (exists) {
                throw new RuntimeException("Recurso já cadastrado nessa sala");
            }
        }

        Recurso recurso = new Recurso();
        recurso.setNome(nome);
        recurso.setQuantidade(quantidade);
        recurso.setTipoRecurso(tipoRecurso);
        recurso.setFixo(fixo);
        recurso.setSala(sala);

        return recursoRepository.save(recurso);
    }

    public List<Recurso> listar() {
        return recursoRepository.findAll();
    }
}