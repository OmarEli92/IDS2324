package it.unicam.cs.repository.Interfaces;

import it.unicam.cs.model.ContenutoMultimediale;
import it.unicam.cs.model.POI;

public interface ContenutoMultimedialeRepository {
    void aggiungiContenutoMultimediale(ContenutoMultimediale contenutoMultimediale);
    void aggiungiContenutoMultimedialeInPending(ContenutoMultimediale contenutoMultimediale);
    void rimuoviContenutoMultimedialeInPending(ContenutoMultimediale contenutoMultimediale);
}

