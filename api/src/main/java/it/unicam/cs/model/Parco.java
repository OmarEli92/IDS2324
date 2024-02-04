package it.unicam.cs.model;

import it.unicam.cs.model.Abstractions.POI;
import it.unicam.cs.model.Abstractions.UtenteAutenticato;
import it.unicam.cs.util.Indirizzo;
import it.unicam.cs.util.Posizione;
import it.unicam.cs.util.TipoTuristico;

import java.util.List;

public class Parco extends POI {
    private boolean presenzaSpecieProtetta;
    private String orarioApertura;
    private List<Itinerario> percorsi;
    private boolean presenzaAnimali;
    private int estensione;

    public Parco(Comune comuneAssociato, int id, String nome, UtenteAutenticato utenteCreatore,
                 Posizione posizione, TipoTuristico tipo, Indirizzo indirizzo, List contenutiMultimediali,
                 List contenutiMultimedialiInPending, List eventiAssociati, boolean presenzaSpecieProtetta,
                 String orarioApertura, List<Itinerario> percorsi, boolean presenzaAnimali, int estensione) {
        super(comuneAssociato, id, nome, utenteCreatore, posizione, tipo,indirizzo, contenutiMultimediali, contenutiMultimedialiInPending, eventiAssociati);
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
