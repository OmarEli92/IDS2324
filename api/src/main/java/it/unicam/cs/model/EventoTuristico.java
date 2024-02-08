package it.unicam.cs.model;

import it.unicam.cs.util.Posizione;

import java.time.LocalDateTime;
import java.util.List;

public class EventoTuristico extends Evento {
    private final String tipo = "EventoTuristico";
    List<ContenutoMultimediale> contenutiMultimediali;

    public EventoTuristico(String ID, String nome,String idComuneAssociato, String descrizione,
                           LocalDateTime dataInizio, LocalDateTime dataFine, Posizione posizione,
                           String idContributore, String idPOIAssociato,
                           List<ContenutoMultimediale> contenutiMultimediali){
        super(ID, nome,idComuneAssociato, descrizione,idContributore,idPOIAssociato, dataInizio, dataFine);
        this.contenutiMultimediali = contenutiMultimediali;


    }

    public String getTipo() {
        return tipo;
    }

}
