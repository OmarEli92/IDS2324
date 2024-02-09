package it.unicam.cs.model;

import it.unicam.cs.util.*;

import java.util.List;

public final class POIIntrattenimento extends POI {
    private int etaConsigliata;
    private String orariApertura;
    private List<Servizio> serviziOfferti;
    private Contatti contatti;
    public POIIntrattenimento(String id, String nome, Posizione posizione, TipoIntrattenimento tipo,
                              String idContributore, String idComuneAssociato, Indirizzo indirizzo,
                              List contenutiMultimediali, List contenutiMultimedialiInPending, List eventiAssociati,
                              int etaConsigliata, String orariApertura,
                              List<Servizio> serviziOfferti, Contatti contatti) {

        super(id, nome, posizione, tipo, idContributore, idComuneAssociato, indirizzo, contenutiMultimediali,
                contenutiMultimedialiInPending, eventiAssociati);

        this.etaConsigliata = etaConsigliata;
        this.orariApertura = orariApertura;
        this.serviziOfferti = serviziOfferti;
        this.contatti = contatti;
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

