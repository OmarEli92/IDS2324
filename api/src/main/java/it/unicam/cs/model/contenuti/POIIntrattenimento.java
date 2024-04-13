package it.unicam.cs.model.contenuti;

import it.unicam.cs.model.Utente;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.util.enums.Servizio;
import it.unicam.cs.util.info.Contatti;
import it.unicam.cs.util.info.Indirizzo;
import it.unicam.cs.util.info.Posizione;
import jakarta.persistence.*;

import java.util.List;
 @Entity
public final class POIIntrattenimento extends POI {
    private int etaConsigliata;
    private String orariApertura;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Servizio> serviziOfferti;
    private Contatti contatti;
    public POIIntrattenimento(Integer id, String nome, Posizione posizione,
                              Utente contributore, Comune comuneAssociato, Indirizzo indirizzo,
                              List contenutiMultimediali, List eventiAssociati,
                              int etaConsigliata, String orariApertura,
                              List<Servizio> serviziOfferti, Contatti contatti) {

        super(id, nome, posizione, contributore, comuneAssociato, indirizzo, contenutiMultimediali,
                eventiAssociati);

        this.etaConsigliata = etaConsigliata;
        this.orariApertura = orariApertura;
        this.serviziOfferti = serviziOfferti;
        this.contatti = contatti;
    }

     public POIIntrattenimento() {

     }

     public int getEtaConsigliata() {
        return etaConsigliata;
    }

    public void setEtaConsigliata(int etàConsigliata) {
        this.etaConsigliata = etaConsigliata;
    }

    public String getOrariApertura() {
        return orariApertura;
    }

    public void setOrariApertura(String orariApertura) {
        this.orariApertura = orariApertura;
    }

    public List<Servizio> getServiziOfferti() {
        return serviziOfferti;
    }

    public void setServiziOfferti(List<Servizio> serviziOfferti) {
        this.serviziOfferti = serviziOfferti;
    }

    public Contatti getContatti() {
        return contatti;
    }

    public void setContatti(Contatti contatti) {
        this.contatti = contatti;
    }
}

