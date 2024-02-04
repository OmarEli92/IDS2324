package it.unicam.cs.repository;

import it.unicam.cs.model.ContenutoMultimediale;
import it.unicam.cs.model.Curatore;
import it.unicam.cs.model.Abstractions.POI;
import it.unicam.cs.repository.Interfaces.ContenutoMultimedialeRepository;

public class ContenutoMultimedialeRepositoryImpl implements ContenutoMultimedialeRepository {
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
    public Curatore getCuratore(){
        return this.poi.getComune().getCuratore();
    }
    @Override
    public void rimuoviContenutoMultimedialeInPending(ContenutoMultimediale contenutoMultimediale){
        this.poi.rimuoviContenutoMultimedialeInPending(contenutoMultimediale);
    }
}
