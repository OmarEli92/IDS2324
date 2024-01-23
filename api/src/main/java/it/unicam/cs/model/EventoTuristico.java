package it.unicam.cs.model;

import java.time.LocalDateTime;
import java.util.List;

public class EventoTuristico extends Evento{
    private final String tipo = "EventoTuristico";

    public EventoTuristico(int ID, String nome, String descrizione, LocalDateTime dataInizio,
                           LocalDateTime dataFine, int idContributore, int idPOIAssociato,
                            List<ContenutoMultimediale> contenutiMultimediali){
        super(ID, nome, descrizione, dataInizio, dataFine, idContributore, idPOIAssociato,contenutiMultimediali);

    }

    public String getTipo() {
        return tipo;
    }

}
