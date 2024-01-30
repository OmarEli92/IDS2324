package it.unicam.cs.service;

import it.unicam.cs.model.ContenutoMultimediale;
import it.unicam.cs.repository.ContenutoMultimedialeRepositoryImpl;

public class InserimentoContenutiMultimedialiService {
private final ContenutoMultimedialeRepositoryImpl contenutoMultimedialeRepository;

    public InserimentoContenutiMultimedialiService(ContenutoMultimedialeRepositoryImpl contenutoMultimedialeRepository) {
        this.contenutoMultimedialeRepository = contenutoMultimedialeRepository;
    }

    public void aggiungiContenutoMultimediale (ContenutoMultimediale contenutoMultimediale){
    this.contenutoMultimedialeRepository.aggiungiContenutoMultimediale(contenutoMultimediale);
    }

    public void aggiungiContenutoMultimedialeInPending(ContenutoMultimediale contenutoMultimediale){
        this.contenutoMultimedialeRepository.aggiungiContenutoMultimedialeInPending(contenutoMultimediale);
    }
}
