package it.unicam.cs.service;

import it.unicam.cs.model.Contenuto;
import it.unicam.cs.model.Evento;
import it.unicam.cs.repository.EventoRepositoryImpl;
import it.unicam.cs.service.Interfaces.IInserimentoContenutiService;

public class InserimentoEventiService implements IInserimentoContenutiService {
private final EventoRepositoryImpl eventoRepository;

    public InserimentoEventiService(EventoRepositoryImpl eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public void aggiungiContenuto(Contenuto evento) {
        this.eventoRepository.aggiungiEvento((Evento) evento);
    }

    public void aggiungiContenutoInPending(Contenuto evento){
    this.eventoRepository.aggiungiEventoInPending((Evento) evento);
    }

}
