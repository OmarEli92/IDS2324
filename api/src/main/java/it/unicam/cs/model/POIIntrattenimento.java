package it.unicam.cs.model;

import it.unicam.cs.model.Abstractions.Evento;
import it.unicam.cs.model.Abstractions.POI;
import it.unicam.cs.model.Abstractions.UtenteAutenticato;
import it.unicam.cs.util.*;

import java.util.List;

public class POIIntrattenimento extends POI {
    private String etàConsigliata;
    private String orariApertura;
    private List<Servizio> serviziOfferti;
    private Contatti contatti;
    public POIIntrattenimento(Comune comuneAssociato, int id, String nome, UtenteAutenticato utenteCreatore, Posizione posizione,
                              TipoIntrattenimento tipo, Indirizzo indirizzo, List<ContenutoMultimediale> contenutiMultimediali,
                              List<ContenutoMultimediale> contenutiMultimedialiInPending, List<Evento> eventi,
                              String etàConsigliata, String orariApertura,
                              List<Servizio> serviziOfferti, Contatti contatti) {
        super(comuneAssociato, id, nome, utenteCreatore, posizione, tipo,indirizzo, contenutiMultimediali, contenutiMultimedialiInPending,eventi);
        this.etàConsigliata = etàConsigliata;
        this.orariApertura = orariApertura;
        this.serviziOfferti = serviziOfferti;
        this.contatti = contatti;
    }

    public String getEtàConsigliata() {
        return etàConsigliata;
    }

    public void setEtàConsigliata(String etàConsigliata) {
        this.etàConsigliata = etàConsigliata;
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

