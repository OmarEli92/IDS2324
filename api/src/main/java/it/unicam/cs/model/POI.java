package it.unicam.cs.model;

import it.unicam.cs.model.Abstractions.UtenteAutenticato;
import it.unicam.cs.util.Posizione;
import it.unicam.cs.util.Tipo;

import java.util.List;

/** La classe POI, Point of interest rappresenta un punto di interesse presente nel territorio del comune.
 **/
public abstract class POI extends Contenuto {
    private final Posizione posizione;
    private final Tipo tipo;
    private final List<ContenutoMultimediale> contenutiMultimediali;
    private final List<ContenutoMultimediale> contenutiMultimedialiInPending;

    public POI(Comune comuneAssociato, int id, String nome, UtenteAutenticato utenteCreatore, Posizione posizione, Tipo tipo, List<ContenutoMultimediale> contenutiMultimediali, List<ContenutoMultimediale> contenutiMultimedialiInPending) {
        super(comuneAssociato, id, nome, utenteCreatore);
        this.posizione = posizione;
        this.tipo = tipo;
        this.contenutiMultimediali=contenutiMultimediali;
        this.contenutiMultimedialiInPending=contenutiMultimedialiInPending;
    }
    public void aggiungiContenutoMultimediale(ContenutoMultimediale contenutoMultimediale){
        this.contenutiMultimediali.add(contenutoMultimediale);
    }

    public void aggiungiContenutoMultimedialeInPending(ContenutoMultimediale contenutoMultimediale) {
        this.contenutiMultimedialiInPending.add(contenutoMultimediale);
    }
    public void rimuoviContenutoMultimedialeInPending(ContenutoMultimediale contenutoMultimediale){
        this.contenutiMultimediali.remove(contenutoMultimediale);
    }

    public List<ContenutoMultimediale> getContenutiMultimediali() {
        return contenutiMultimediali;
    }
    public Comune getComune(){
        return this.comuneAssociato;
    }
}


