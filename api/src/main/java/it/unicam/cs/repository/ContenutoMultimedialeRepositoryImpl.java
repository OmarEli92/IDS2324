package it.unicam.cs.repository;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.ContenutoMultimediale;
import it.unicam.cs.model.POI;

public class ContenutoMultimedialeRepositoryImpl implements ContenutoMultimedialeRepository{
    private final POI poi;

    public ContenutoMultimedialeRepositoryImpl(POI poi) {
        this.poi=poi;
    }

    @Override
    public void aggiungiContenutoMultimediale(ContenutoMultimediale contenutoMultimediale) {
        this.poi.aggiungiContenutoMultimediale(contenutoMultimediale);
    }

    @Override
    public void aggiungiContenutoMultimedialeInPending(ContenutoMultimediale contenutoMultimediale) {
        this.poi.aggiungiContenutoMultimedialeInPending(contenutoMultimediale);
    }
}
