package it.unicam.cs.model.contenuti;

import it.unicam.cs.model.Utente;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.util.info.Indirizzo;
import it.unicam.cs.util.info.Posizione;

import java.util.List;

public final class Parco extends POI {
    private boolean presenzaSpecieProtetta;
    private String orarioApertura;
    private List<Itinerario> percorsi;
    private boolean presenzaAnimali;
    private int estensione;

    public Parco(Integer id, String nome, Posizione posizione, String tipo,
                 Utente contributore, Comune comuneAssociato, Indirizzo indirizzo,
                 List contenutiMultimediali, List contenutiMultimedialiInPending, List eventiAssociati, boolean presenzaSpecieProtetta,
                 String orarioApertura, List<Itinerario> percorsi, boolean presenzaAnimali, int estensione) {

        super(id, nome, posizione, tipo, contributore, comuneAssociato, indirizzo, contenutiMultimediali,
                contenutiMultimedialiInPending, eventiAssociati);

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

    public String getOrarioApertura() {
        return orarioApertura;
    }

    public void setOrarioApertura(String orarioApertura) {
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
