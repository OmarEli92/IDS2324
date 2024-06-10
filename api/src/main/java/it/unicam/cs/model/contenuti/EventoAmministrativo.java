package it.unicam.cs.model.contenuti;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.util.enums.StatoElemento;
import it.unicam.cs.util.enums.TipoAmministrativo;
import it.unicam.cs.util.enums.TipoEvento;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
public class EventoAmministrativo extends Evento {
    private TipoAmministrativo tipo;
    private String responsabile;


    public EventoAmministrativo(Comune comuneAssociato, String nome, String descrizione, boolean attivo, TipoEvento tipoEvento, Utente contributore, StatoElemento stato, POI poiAssociato, LocalDateTime dataInizio, LocalDateTime dataFine, List<ContenutoMultimediale> contenutiMultimediali, TipoAmministrativo tipo, String responsabile) {
        super(comuneAssociato, nome, descrizione, attivo, tipoEvento, contributore,stato, poiAssociato, dataInizio, dataFine, contenutiMultimediali);
        this.tipo = tipo;
        this.responsabile = responsabile;
    }
}
