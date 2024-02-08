package it.unicam.cs.model;

import java.time.LocalDateTime;
import java.util.List;

public class EventoIntrattimento extends Evento{
    private final String tipo = "EventoIntrattimento";
    private final List<ContenutoMultimediale> contenutiMultimediali;
    public EventoIntrattimento(String id, String nome, String idcomuneAssociato, String descrizione,
                               String idContributore, String idPoiAssociato, LocalDateTime dataInizio,
                               LocalDateTime dataFine, List<ContenutoMultimediale> contenutiMultimediali) {
        super(id, nome, idcomuneAssociato, descrizione, idContributore, idPoiAssociato, dataInizio, dataFine);
        this.contenutiMultimediali = contenutiMultimediali;
    }
}
