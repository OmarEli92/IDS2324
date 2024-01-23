package it.unicam.cs.model;

import it.unicam.cs.util.Posizione;

import java.time.LocalDateTime;
import java.util.List;

public class EventoTuristico extends Evento{
    private final String tipo = "EventoTuristico";

    public EventoTuristico(int ID, String nome, String descrizione, LocalDateTime dataInizio,
                           LocalDateTime dataFine, Posizione posizione,int idContributore, int idPOIAssociato,
                           List<ContenutoMultimediale> contenutiMultimediali, int idComune){
        super(ID, nome, descrizione, dataInizio, dataFine,posizione, idContributore, idPOIAssociato,contenutiMultimediali,idComune);

    }

    public String getTipo() {
        return tipo;
    }

}
