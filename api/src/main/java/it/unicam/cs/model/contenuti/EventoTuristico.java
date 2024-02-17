package it.unicam.cs.model.contenuti;

import it.unicam.cs.model.abstractions.Utente;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.util.info.Posizione;

import java.time.LocalDateTime;
import java.util.List;

public class EventoTuristico extends Evento {
    private final String tipo = "EventoTuristico";
    List<ContenutoMultimediale> contenutiMultimediali;

    public EventoTuristico(Integer ID, String nome, Comune comuneAssociato, String descrizione,
                           LocalDateTime dataInizio, LocalDateTime dataFine, Posizione posizione,
                           Utente contributore, POI poiAssociato,
                           List<ContenutoMultimediale> contenutiMultimediali){
        super(ID, nome,comuneAssociato, descrizione,contributore,poiAssociato, dataInizio, dataFine);
        this.contenutiMultimediali = contenutiMultimediali;


    }

    public String getTipo() {
        return tipo;
    }

}
