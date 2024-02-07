package it.unicam.cs.repository;

import it.unicam.cs.model.ContenutoMultimediale;
import it.unicam.cs.model.Curatore;
import it.unicam.cs.model.POI;
import it.unicam.cs.repository.Interfaces.ContenutoMultimedialeRepository;

public class ContenutoMultimedialeRepositoryImpl implements ContenutoMultimedialeRepository {


    @Override
    public void aggiungiContenutoMultimediale(ContenutoMultimediale contenutoMultimediale) {
        contenutoMultimediale.getPoiAssociato().aggiungiContenutoMultimediale(contenutoMultimediale);
    }

    @Override
    public void aggiungiContenutoMultimedialeInPending(ContenutoMultimediale contenutoMultimediale) {
        contenutoMultimediale.getPoiAssociato().aggiungiContenutoMultimedialeInPending(contenutoMultimediale);
    }
    @Override
    public void rimuoviContenutoMultimedialeInPending(ContenutoMultimediale contenutoMultimediale){
        contenutoMultimediale.getPoiAssociato().rimuoviContenutoMultimedialeInPending(contenutoMultimediale);
    }
}
