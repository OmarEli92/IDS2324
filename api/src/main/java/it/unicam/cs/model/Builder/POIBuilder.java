package it.unicam.cs.model.Builder;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.util.info.Indirizzo;
import it.unicam.cs.util.info.Posizione;
import lombok.Data;

import java.util.List;
@Data
public abstract class POIBuilder {
    private Integer Id;
    private String nome;
    private Posizione posizione;
    private Utente contributore;
    private Comune comuneAssociato;
    private Indirizzo indirizzo;
    private List<Evento> eventiAssociati;
    private List<ContenutoMultimediale> contenutiMultimediali;

    public void setId(Integer id) {
        Id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPosizione(Posizione posizione) {
        this.posizione = posizione;
    }

    public void setContributore(Utente contributore) {
        this.contributore = contributore;
    }

    public void setComuneAssociato(Comune comuneAssociato) {
        this.comuneAssociato = comuneAssociato;
    }

    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }

    public void setEventiAssociati(List<Evento> eventiAssociati) {
        this.eventiAssociati = eventiAssociati;
    }

    public void setContenutiMultimediali(List<ContenutoMultimediale> contenutiMultimediali) {
        this.contenutiMultimediali = contenutiMultimediali;
    }
    abstract POI build();
}
