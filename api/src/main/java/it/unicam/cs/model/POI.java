package it.unicam.cs.model;

import java.util.List;

/** La classe POI, Point of interest rappresenta un punto di interesse presente nel territorio del comune.
 **/
public class POI {
    private final String nome;
    private final String posizione;
    private final String descrizione;
    private final String dataCreazione;
    private List<ContenutoMultimediale> contenutiAssociati;

    public POI(String nome, String posizione, String descrizione, String dataCreazione, List<ContenutoMultimediale> contenutiAssociati) {
        this.nome = nome;
        this.posizione = posizione;
        this.descrizione = descrizione;
        this.dataCreazione = dataCreazione;
        this.contenutiAssociati = contenutiAssociati;
    }
}
