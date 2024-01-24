package it.unicam.cs.service;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Evento;
import it.unicam.cs.repository.EventoRepository;
import it.unicam.cs.repository.EventoRepositoryImpl;

public class VerificaEventiService {
private final EventoRepositoryImpl eventoRepository;

    public VerificaEventiService(EventoRepositoryImpl eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public void verificaEvento(Evento evento) {
    this.eventoRepository.getCuratore().verificaEvento(evento);
    }
    public void validaEvento(Evento evento) {
        this.eventoRepository.rimuoviEventoInPending(evento);
        this.eventoRepository.aggiungiEvento(evento);
    }
    public void invalidaEvento(Evento evento) {
        this.eventoRepository.rimuoviEventoInPending(evento);
    }

}
