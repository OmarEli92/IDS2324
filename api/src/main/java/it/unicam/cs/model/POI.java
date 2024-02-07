package it.unicam.cs.model;

import it.unicam.cs.util.Indirizzo;
import it.unicam.cs.util.Posizione;

import java.util.List;

/** La classe POI, Point of interest rappresenta un punto di interesse presente nel territorio del comune.
 **/
public abstract class POI<T>{
    private final int id;
    private final String nome;
    private final Posizione posizione;
    private final T tipo;
    private final int idContributore;
    private final Comune comuneAssociato;
    private final Indirizzo indirizzo;
    private final List<ContenutoMultimediale> contenutiMultimediali;
    private final List<ContenutoMultimediale> contenutiMultimedialiInPending;
    private final List<Evento> eventiAssociati;
    private final List<Evento> eventiassociatiInPending;

    public POI(int id, String nome,Posizione posizione, T tipo, int idContributore,
               Comune comuneAssociato, Indirizzo indirizzo, List<ContenutoMultimediale> contenutiMultimediali,
               List<ContenutoMultimediale> contenutiMultimedialiInPending, List<Evento> eventiAssociati,List<Evento>eventiassociatiInPending) {
        this.id = id;
        this.nome = nome;
        this.posizione = posizione;
        this.tipo = tipo;
        this.idContributore = idContributore;
        this.comuneAssociato = comuneAssociato;
        this.indirizzo = indirizzo;
        this.contenutiMultimediali=contenutiMultimediali;
        this.contenutiMultimedialiInPending=contenutiMultimedialiInPending;
        this.eventiAssociati = eventiAssociati;
        this.eventiassociatiInPending=eventiassociatiInPending;
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

    public void aggiungiEvento(Evento evento){
        this.eventiAssociati.add(evento);
    }
    public void aggiungiEventoInPending(Evento evento){
        this.eventiassociatiInPending.add(evento);
    }
    public void rimuoviEventoInPending(Evento evento){
        this.eventiassociatiInPending.remove(evento);
    }

    public List<ContenutoMultimediale> getContenutiMultimediali() {
        return contenutiMultimediali;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Posizione getPosizione() {
        return posizione;
    }

    public T getTipo() {
        return tipo;
    }

    public int getIdContributore() {
        return idContributore;
    }

    public Comune getComuneAssociato() {
        return comuneAssociato;
    }

    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    public List<ContenutoMultimediale> getContenutiMultimedialiInPending() {
        return contenutiMultimedialiInPending;
    }

    public List<Evento> getEventiAssociati() {
        return eventiAssociati;
    }

    /*
    verifica se un contenuto multimediale è già stato inserito
     */
    public void verificaContenutoMultimediale (ContenutoMultimediale contenutoMultimediale){

    }
    /*
    verifica che nel determinato periodo dell'evento passato non ci siano altri eventi
    associati a questo POI
     */
    public void verificaEvento(Evento evento){

    }
}


