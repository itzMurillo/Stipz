package br.com.stipz.service;

import br.com.stipz.domain.Evento;
import br.com.stipz.repository.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public Evento criar(Evento evento) {
        return eventoRepository.save(evento);
    }

    public List<Evento> listar() {
        return eventoRepository.findAll();
    }
}
