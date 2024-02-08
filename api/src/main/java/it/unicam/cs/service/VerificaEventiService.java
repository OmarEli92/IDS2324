package it.unicam.cs.service;

import it.unicam.cs.repository.IEventoRepository;

public class VerificaEventiService{
    IEventoRepository eventoRepository;
    public VerificaEventiService(IEventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }
}
