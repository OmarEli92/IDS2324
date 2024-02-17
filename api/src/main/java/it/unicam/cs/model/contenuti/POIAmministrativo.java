package it.unicam.cs.model.contenuti;

import it.unicam.cs.model.abstractions.Utente;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.util.info.Contatti;
import it.unicam.cs.util.info.Indirizzo;
import it.unicam.cs.util.info.Posizione;

import java.util.List;

public class POIAmministrativo extends POI {
    private String orariApertura;
    private String responsabile;
    private Contatti contatti;
    public POIAmministrativo(Integer id, String nome, Posizione posizione, String tipo,
                             Utente contributore, Comune comuneAssociato, Indirizzo indirizzo,
                             List contenutiMultimediali, List contenutiMultimedialiInPending, List eventiAssociati,
                             String orariApertura, String responsabile, Contatti contatti) {


        super(id, nome, posizione, tipo, contributore, comuneAssociato, indirizzo, contenutiMultimediali,
                contenutiMultimedialiInPending, eventiAssociati);
        this.orariApertura = orariApertura;
        this.responsabile = responsabile;
        this.contatti = contatti;
    }

    public String getOrariApertura() {
        return orariApertura;
    }

    public void setOrariApertura(String orariApertura) {
        this.orariApertura = orariApertura;
    }

    public Contatti getContatti() {
        return contatti;
    }

    public void setContatti(Contatti contatti) {
        this.contatti = contatti;
    }
}

