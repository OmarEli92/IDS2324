package it.unicam.cs.model.contenuti;

import it.unicam.cs.model.Utente;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.util.enums.TipoAmministrativo;
import it.unicam.cs.util.enums.TipoIntrattenimento;
import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Entity
@Data
public class EventoIntrattimento extends Evento {
    private TipoIntrattenimento tipo;
    private final List<ContenutoMultimediale> contenutiMultimediali;
    public EventoIntrattimento(Integer id, String nome, Comune comuneAssociato, String descrizione,
                               Utente contributore, POI poiAssociato, LocalDateTime dataInizio,
                               LocalDateTime dataFine, TipoIntrattenimento tipo, List<ContenutoMultimediale> contenutiMultimediali) {
        super(id, comuneAssociato, nome, descrizione, contributore, poiAssociato, dataInizio, dataFine);
        this.tipo = tipo;
        this.contenutiMultimediali = contenutiMultimediali;
    }
}
