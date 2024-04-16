package it.unicam.cs.model.contenuti;

import it.unicam.cs.model.Utente;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.util.enums.TipoTuristico;
import it.unicam.cs.util.info.Posizione;
import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Entity
@Data
public class EventoTuristico extends Evento {
    private TipoTuristico tipo;
    List<ContenutoMultimediale> contenutiMultimediali;

    public EventoTuristico(Integer ID, String nome, Comune comuneAssociato, String descrizione,
                           LocalDateTime dataInizio, LocalDateTime dataFine, Posizione posizione,
                           Utente contributore, POI poiAssociato, TipoTuristico tipo,
                           List<ContenutoMultimediale> contenutiMultimediali){
        super(ID, comuneAssociato, nome, descrizione,contributore,poiAssociato, dataInizio, dataFine);
        this.contenutiMultimediali = contenutiMultimediali;


    }


}
