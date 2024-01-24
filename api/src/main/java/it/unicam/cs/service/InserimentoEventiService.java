package it.unicam.cs.service;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Evento;
import it.unicam.cs.repository.EventoRepository;
import it.unicam.cs.repository.EventoRepositoryImpl;
import it.unicam.cs.util.Tipo;
import it.unicam.cs.model.POI;

public class InserimentoEventiService {
private final EventoRepositoryImpl eventoRepository;

    public InserimentoEventiService(EventoRepositoryImpl eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public void aggiungiEvento(Evento evento) {
        this.eventoRepository.aggiungiEvento(evento);
    }

    public void aggiungiEventoInPending(Evento evento){
    this.eventoRepository.aggiungiEventoInPending(evento);
    }



}
