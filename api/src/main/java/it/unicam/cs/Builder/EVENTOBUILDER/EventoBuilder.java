package it.unicam.cs.Builder.EVENTOBUILDER;

import it.unicam.cs.Visitor.Evento.IEventoBuilderVisitable;
import it.unicam.cs.Visitor.Evento.IEventoBuilderVisitor;
import it.unicam.cs.Visitor.Evento.IEventoDtoVisitor;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.DTO.EventoDto;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.util.enums.StatoElemento;
import it.unicam.cs.util.info.Posizione;
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
public abstract class EventoBuilder implements IEventoBuilderVisitable {
    private Comune comuneAssociato;
    private String nome;
    private Posizione posizione;
    private String descrizione;
    private Utente contributore;
    private StatoElemento stato;
    private POI poiAssociato;
    private LocalDateTime dataInizio;
    private LocalDateTime dataFine;
    private List<ContenutoMultimediale> contenutiMultimediali;


    public void setComuneAssociato(Comune comuneAssociato) {
        this.comuneAssociato = this.poiAssociato.getComuneAssociato();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPosizione(Posizione posizione) {
        this.posizione = posizione;
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

    public void setDataFine(LocalDateTime dataFine) {
        this.dataFine = dataFine;
    }
    public abstract Evento build();

    @Override
    public abstract void accept(IEventoBuilderVisitor eventoBuilderVisitor, EventoDto eventoDto) ;
}
