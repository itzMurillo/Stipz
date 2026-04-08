package br.com.stipz.service;

import br.com.stipz.domain.Sala;
import br.com.stipz.repository.SalaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SalaService {

    private final SalaRepository salaRepository;

    public SalaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    public Sala criar(Sala sala) {
        return salaRepository.save(sala);
    }

    public List<Sala> listar() {
        return salaRepository.findAll();
    }

    public Sala buscar(Long id) {
        return salaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sala não encontrada"));
    }

    public void deletar(Long id) {
        salaRepository.deleteById(id);
    }
}
