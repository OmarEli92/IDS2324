package it.unicam.cs.model;

import it.unicam.cs.util.Posizione;

import java.time.LocalDateTime;
import java.util.List;

public class EventoTuristico extends Evento {
    private final String tipo = "EventoTuristico";

    public EventoTuristico(int ID, String nome,int idComuneAssociato, String descrizione, LocalDateTime dataInizio,
                           LocalDateTime dataFine, Posizione posizione,int idContributore, POI POIAssociato,
                           List<ContenutoMultimediale> contenutiMultimediali){
        super(ID, nome,idComuneAssociato, descrizione,idContributore,POIAssociato, dataInizio, dataFine);


    }

    public String getTipo() {
        return tipo;
    }

}
