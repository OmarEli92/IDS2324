package it.unicam.cs.model.contenuti;

import it.unicam.cs.model.Utente;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.util.enums.Servizio;
import it.unicam.cs.util.enums.StatoElemento;
import it.unicam.cs.util.enums.TipoEvento;
import it.unicam.cs.util.enums.TipoIntrattenimento;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
public class EventoIntrattimento extends Evento {
    private TipoIntrattenimento tipo;
    private int etaConsigliata;
    private List<Servizio> serviziOfferti;
    public EventoIntrattimento(Comune comuneAssociato, String nome, String descrizione, boolean attivo, TipoEvento tipoEvento,
                               Utente contributore, StatoElemento stato, POI poiAssociato, LocalDateTime dataInizio, LocalDateTime dataFine,
                               List<ContenutoMultimediale> contenutiMultiediali, TipoIntrattenimento tipo, int etaConsigliata, List<Servizio> serviziOfferti ) {
        super(comuneAssociato, nome, descrizione, attivo, tipoEvento, contributore,stato, poiAssociato, dataInizio, dataFine,contenutiMultiediali);
        this.tipo = tipo;
        this.etaConsigliata = etaConsigliata;
        this.serviziOfferti = serviziOfferti;
    }
}
