package it.unicam.cs.model;

import it.unicam.cs.model.Abstractions.Utente;
import it.unicam.cs.util.Indirizzo;
import it.unicam.cs.util.Posizione;
import it.unicam.cs.util.enums.StatoContenuto;
import it.unicam.cs.util.enums.TipoTuristico;

import java.time.LocalDateTime;
import java.util.List;

public final class Parco extends POI {
    private boolean presenzaSpecieProtetta;
    private LocalDateTime orarioApertura;
    private List<Itinerario> percorsi;
    private boolean presenzaAnimali;
    private int estensione;

    public Parco(String nome, Posizione posizione, Utente contributore, Comune comuneAssociato, Indirizzo indirizzo, StatoContenuto statoContenuto,boolean presenzaSpecieProtetta,
                 LocalDateTime orarioApertura, List<Itinerario> percorsi, boolean presenzaAnimali, int estensione) {

        super(nome, posizione,contributore, comuneAssociato, indirizzo,statoContenuto);

        this.presenzaSpecieProtetta = presenzaSpecieProtetta;
        this.orarioApertura = orarioApertura;
        this.percorsi = percorsi;
        this.presenzaAnimali = presenzaAnimali;
        this.estensione = estensione;
    }

    public boolean isPresenzaSpecieProtetta() {
        return presenzaSpecieProtetta;
    }

    public void setPresenzaSpecieProtetta(boolean presenzaSpecieProtetta) {
        this.presenzaSpecieProtetta = presenzaSpecieProtetta;
    }

    public LocalDateTime getOrarioApertura() {
        return orarioApertura;
    }

    public void setOrarioApertura(LocalDateTime orarioApertura) {
        this.orarioApertura = orarioApertura;
    }

    public List<Itinerario> getPercorsi() {
        return percorsi;
    }

    public void setPercorsi(List<Itinerario> percorsi) {
        this.percorsi = percorsi;
    }

    public boolean isPresenzaAnimali() {
        return presenzaAnimali;
    }

    public void setPresenzaAnimali(boolean presenzaAnimali) {
        this.presenzaAnimali = presenzaAnimali;
    }

    public int getEstensione() {
        return estensione;
    }

    public void setEstensione(int estensione) {
        this.estensione = estensione;
    }
}
