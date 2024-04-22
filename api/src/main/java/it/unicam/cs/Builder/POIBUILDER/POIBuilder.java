package it.unicam.cs.Builder.POIBUILDER;

import it.unicam.cs.Visitor.POI.IPOIBuilderVisitor;
import it.unicam.cs.Visitor.POI.IPoiBuilderVisitable;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.DTO.PoiDto;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.util.enums.StatoElemento;
import it.unicam.cs.util.info.Indirizzo;
import it.unicam.cs.util.info.Posizione;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Data
@AllArgsConstructor @NoArgsConstructor
public abstract class POIBuilder implements IPoiBuilderVisitable {
    private Integer Id;
    private String nome;
    private Posizione posizione;
    private Utente contributore;
    private StatoElemento stato;
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

    public void setStato(Utente utente) {
        for(Ruolo ruolo : utente.getRuoli()){
            if(ruolo.getNome().equalsIgnoreCase("Curatore") || ruolo.getNome().equalsIgnoreCase("Contributore_Autorizzato")) {
                this.stato = StatoElemento.PUBBLICATO;
            }
            else if (ruolo.getNome().equalsIgnoreCase("Contributore")) {
                this.stato = StatoElemento.PENDING;
            }
        }
    }

    abstract POI build();

    @Override
    public abstract void accept(IPOIBuilderVisitor ipoiBuilderVisitor, PoiDto poiDto);
}
