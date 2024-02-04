package it.unicam.cs.model.Abstractions;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.ContenutoMultimediale;
import it.unicam.cs.util.Indirizzo;
import it.unicam.cs.util.Posizione;

import java.util.List;

/** La classe POI, Point of interest rappresenta un punto di interesse presente nel territorio del comune.
 **/
public abstract class POI<T> extends Contenuto {
    private final Posizione posizione;
    private final T tipo;
    private final Indirizzo indirizzo;
    private final List<ContenutoMultimediale> contenutiMultimediali;
    private final List<ContenutoMultimediale> contenutiMultimedialiInPending;
    private final List<Evento> eventiAssociati;

    public POI(Comune comuneAssociato, int id, String nome, UtenteAutenticato utenteCreatore,
               Posizione posizione, T tipo, Indirizzo indirizzo, List<ContenutoMultimediale> contenutiMultimediali,
               List<ContenutoMultimediale> contenutiMultimedialiInPending, List<Evento> eventiAssociati) {
        super(comuneAssociato, id, nome, utenteCreatore);
        this.posizione = posizione;
        this.tipo = tipo;
        this.indirizzo = indirizzo;
        this.contenutiMultimediali=contenutiMultimediali;
        this.contenutiMultimedialiInPending=contenutiMultimedialiInPending;
        this.eventiAssociati = eventiAssociati;
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


