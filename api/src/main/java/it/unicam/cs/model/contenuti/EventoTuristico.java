package it.unicam.cs.model.contenuti;

import it.unicam.cs.model.Utente;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.util.enums.TipoTuristico;
import it.unicam.cs.util.info.Posizione;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Entity
@Data
public class EventoTuristico extends Evento {
    private TipoTuristico tipo;

    public EventoTuristico(Integer ID, Comune comuneAssociato, String nome, String descrizione,
                           Utente contributore, POI poiAssociato, LocalDateTime dataInizio, LocalDateTime dataFine,List<ContenutoMultimediale> contenutiMultimediali,
                           TipoTuristico tipo){
        super(ID, comuneAssociato, nome, descrizione,contributore,poiAssociato, dataInizio, dataFine, contenutiMultimediali);
        this.tipo = tipo;
    }


}
