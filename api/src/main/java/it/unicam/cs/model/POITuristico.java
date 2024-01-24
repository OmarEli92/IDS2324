package it.unicam.cs.model;

import it.unicam.cs.util.Posizione;

import java.time.LocalDateTime;
import java.util.List;

public class POITuristico extends POI{
    public POITuristico(int ID, String nome, Posizione posizione, String descrizione, LocalDateTime dataCreazione,
                        List<ContenutoMultimediale> contenutiMultimediali, int IDContributore, int IDComune) {
        super(ID, nome, posizione, descrizione, dataCreazione, contenutiMultimediali, IDContributore, IDComune);
    }
}
