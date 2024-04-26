package it.unicam.cs.service;

import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.repository.IEventoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class EventoService {
    private IEventoRepository eventoRepository;

    public void salvaContenutoMultimediale(Integer idEvento, ContenutoMultimediale contenutoMultimediale){
        Evento evento = eventoRepository.getReferenceById(idEvento);
        evento.aggiungiContenutoMultimediale(contenutoMultimediale);
        eventoRepository.save(evento);
    }
}
