package it.unicam.cs.model.contenuti;

import it.unicam.cs.model.abstractions.Utente;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.util.enums.CollezioniMuseo;
import it.unicam.cs.util.info.Contatti;
import it.unicam.cs.util.info.Indirizzo;
import it.unicam.cs.util.info.Posizione;

import java.util.List;

public final class Museo extends POI {
    private String orariApertura;
    private String responsabile;
    private Contatti contatti;
    private int numeroSale;
    private List<CollezioniMuseo> collezioni;
    public Museo(Integer id, String nome, Posizione posizione, String tipo,
                 Utente contributore, Comune comuneAssociato, Indirizzo indirizzo,
                 List contenutiMultimediali, List contenutiMultimedialiInPending, List eventiAssociati,
                 String orariApertura, String responsabile, Contatti contatti, int numeroSale, List<CollezioniMuseo> collezioni) {
        super(id, nome, posizione, tipo, contributore, comuneAssociato, indirizzo, contenutiMultimediali,
                contenutiMultimedialiInPending, eventiAssociati);
        this.orariApertura = orariApertura;
        this.responsabile = responsabile;
        this.contatti = contatti;
        this.numeroSale = numeroSale;
        this.collezioni = collezioni;
    }

    public String getOrariApertura() {
        return orariApertura;
    }

    public void setOrariApertura(String orariApertura) {
        this.orariApertura = orariApertura;
    }

    public String getResponsabile() {
        return responsabile;
    }

    public void setResponsabile(String responsabile) {
        this.responsabile = responsabile;
    }

    public Contatti getContatti() {
        return contatti;
    }

    public void setContatti(Contatti contatti) {
        this.contatti = contatti;
    }

    public int getNumeroSale() {
        return numeroSale;
    }

    public void setNumeroSale(int numeroSale) {
        this.numeroSale = numeroSale;
    }

    public List<CollezioniMuseo> getCollezioni() {
        return collezioni;
    }

    public void setCollezioni(List<CollezioniMuseo> collezioni) {
        this.collezioni = collezioni;
    }
}
