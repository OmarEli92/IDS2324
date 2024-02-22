package it.unicam.cs.model;

import it.unicam.cs.model.Abstractions.Utente;
import it.unicam.cs.util.*;
import it.unicam.cs.util.enums.Servizio;
import it.unicam.cs.util.enums.StatoContenuto;
import it.unicam.cs.util.enums.TipoIntrattenimento;

import java.time.LocalDateTime;
import java.util.List;

public final class POIIntrattenimento extends POI {
    private int etaConsigliata;
    private LocalDateTime orariApertura;
    private List<Servizio> serviziOfferti;
    private Contatti contatti;
    public POIIntrattenimento(String nome, Posizione posizione, Utente contributore, Comune comuneAssociato, Indirizzo indirizzo, StatoContenuto statoContenuto,
                              int etaConsigliata, LocalDateTime orariApertura,
                              List<Servizio> serviziOfferti, Contatti contatti) {

        super(nome, posizione, contributore, comuneAssociato, indirizzo, statoContenuto);

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

    public LocalDateTime getOrariApertura() {
        return orariApertura;
    }

    public void setOrariApertura(LocalDateTime orariApertura) {
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

