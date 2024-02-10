package it.unicam.cs.model;

import it.unicam.cs.model.Abstractions.Utente;

import java.time.LocalDateTime;
import java.util.List;

public class EventoIntrattimento extends Evento{
    private final String tipo = "EventoIntrattimento";
    private final List<ContenutoMultimediale> contenutiMultimediali;
    public EventoIntrattimento(Integer id, String nome, Comune comuneAssociato, String descrizione,
                               Utente contributore, POI poiAssociato, LocalDateTime dataInizio,
                               LocalDateTime dataFine, List<ContenutoMultimediale> contenutiMultimediali) {
        super(id, nome, comuneAssociato, descrizione, contributore, poiAssociato, dataInizio, dataFine);
        this.contenutiMultimediali = contenutiMultimediali;
    }
}
