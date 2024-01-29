package it.unicam.cs.service;

import it.unicam.cs.model.ContenutoMultimediale;
import it.unicam.cs.repository.ContenutoMultimedialeRepositoryImpl;

public class VerificaContenutoMultimedialeService {
private final ContenutoMultimedialeRepositoryImpl contenutoMultimedialeRepository;

    public VerificaContenutoMultimedialeService(ContenutoMultimedialeRepositoryImpl contenutoMultimedialeRepository) {
        this.contenutoMultimedialeRepository = contenutoMultimedialeRepository;
    }
    public void verificaContenutoMultimediale(ContenutoMultimediale contenutoMultimediale){
        this.contenutoMultimedialeRepository.getCuratore().verificaContenutoMultimediale(contenutoMultimediale);
    }
    public void validaContenutoMultimediale(ContenutoMultimediale contenutoMultimediale){
        this.contenutoMultimedialeRepository.rimuoviContenutoMultimedialeInPending(contenutoMultimediale);
        this.contenutoMultimedialeRepository.aggiungiContenutoMultimediale(contenutoMultimediale);
    }
    public void invalidaContenutoMultimediale(ContenutoMultimediale contenutoMultimediale){
        this.contenutoMultimedialeRepository.rimuoviContenutoMultimedialeInPending(contenutoMultimediale);
    }
}
