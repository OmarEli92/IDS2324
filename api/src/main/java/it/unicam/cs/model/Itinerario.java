package it.unicam.cs.model;

import it.unicam.cs.util.Posizione;

import java.time.LocalDateTime;
import java.util.List;

/** La classe Itinerario rappresenta un percorso che collega più POI e può anche contenere contenuti multimediali **/
public class Itinerario {
    private final int ID;
    private final String nome;
    private final String descrizione;
    private final List<POI> puntiDiInteresse;
    private final LocalDateTime dataCreazione;
    private final List<ContenutoMultimediale> contenutiMultimediali;
    private final String IDContributore;
    public Itinerario(int ID, String nome, String descrizione, List<POI> puntiDiInteresse,
                      LocalDateTime dataCreazione, List<ContenutoMultimediale> contenutiMultimediali,
                      String IDContributore) {
        this.ID = ID;
        this.nome = nome;
        this.descrizione = descrizione;
        this.puntiDiInteresse = puntiDiInteresse;
        this.dataCreazione = dataCreazione;
        this.contenutiMultimediali = contenutiMultimediali;
        this.IDContributore = IDContributore;
    }

}
