package it.unicam.cs.model;

import it.unicam.cs.model.Abstractions.Evento;
import it.unicam.cs.model.Abstractions.POI;
import it.unicam.cs.model.Abstractions.UtenteAutenticato;
import it.unicam.cs.util.Contatti;
import it.unicam.cs.util.Indirizzo;
import it.unicam.cs.util.Posizione;
import it.unicam.cs.util.TipoAmministrativo;

import java.util.List;

public class POIAmministrativo extends POI {
    private String orariApertura;
    private String responsabile;
    private Contatti contatti;
    public POIAmministrativo(Comune comuneAssociato, int id, String nome, UtenteAutenticato utenteCreatore, Posizione posizione,
                             TipoAmministrativo tipo, Indirizzo indirizzo, List<ContenutoMultimediale> contenutiMultimediali,
                             List<ContenutoMultimediale> contenutiMultimedialiInPending, List<Evento> eventi,
                             String orariApertura, String responsabile, Contatti contatti) {


        super(comuneAssociato, id, nome, utenteCreatore, posizione, tipo, indirizzo, contenutiMultimediali, contenutiMultimedialiInPending,eventi);
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

