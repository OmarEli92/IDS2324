package it.unicam.cs.repository;

import it.unicam.cs.model.ContenutoMultimediale;

public class ContenutoMultimedialeRepositoryImpl implements ContenutoMultimedialeRepository{
    @Override
    public void aggiungiContenutoMultimediale(ContenutoMultimediale contenutoMultimediale) {
        contenutoMultimediale.getPoiAssociato().getContenutiMultimediali().add(contenutoMultimediale);
    }

    @Override
    public void aggiungiContenutoMultimedialeInPending(ContenutoMultimediale contenutoMultimediale) {
        contenutoMultimediale.getPoiAssociato().getContenutiMultimedialiInPending().add(contenutoMultimediale);
    }
}
