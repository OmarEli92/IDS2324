package it.unicam.cs.model.contenuti;

import it.unicam.cs.model.Utente;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.util.enums.StatoElemento;
import it.unicam.cs.util.info.Indirizzo;
import it.unicam.cs.util.info.Posizione;
import jakarta.persistence.Entity;
import lombok.Data;

import java.util.List;
@Entity
@Data
public final class Monumento extends POI {

    private int annoRealizzazione;
    private String descrizione;
    private String autore;
    private double altezza;
    private double lunghezza;
    private String architettura;

    public Monumento(String nome, Posizione posizione, Utente contributore, StatoElemento stato, Comune comuneAssociato, Indirizzo indirizzo, List<Evento> eventiAssociati, List<ContenutoMultimediale> contenutiMultimediali, int annoRealizzazione, String descrizione, String autore, double altezza, double lunghezza, String architettura) {
        super(nome, posizione, contributore, stato, comuneAssociato, indirizzo, eventiAssociati, contenutiMultimediali);
        this.annoRealizzazione = annoRealizzazione;
        this.descrizione = descrizione;
        this.autore = autore;
        this.altezza = altezza;
        this.lunghezza = lunghezza;
        this.architettura = architettura;
    }
}
