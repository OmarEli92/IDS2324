package it.unicam.cs.Builder.EVENTOBUILDER;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Data
@AllArgsConstructor @NoArgsConstructor
public abstract class EventoBuilder {
    private Integer id;
    private Comune comuneAssociato;
    private String nome;
    private String descrizione;
    private Utente contributore;
    private POI poiAssociato;
    private LocalDateTime dataInizio;
    private LocalDateTime dataFine;
    private List<ContenutoMultimediale> contenutiMultimediali;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setComuneAssociato(Comune comuneAssociato) {
        this.comuneAssociato = this.poiAssociato.getComuneAssociato();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setContributore(Utente contributore) {
        this.contributore = contributore;
    }

    public void setPoiAssociato(POI poiAssociato) {
        this.poiAssociato = poiAssociato;
    }

    public void setDataInizio(LocalDateTime dataInizio) {
        this.dataInizio = dataInizio;
    }

    public void setDataFine(LocalDateTime dataFine) {
        this.dataFine = dataFine;
    }
    public abstract Evento build();
}
