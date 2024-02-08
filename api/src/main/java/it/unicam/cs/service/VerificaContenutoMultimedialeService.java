package it.unicam.cs.service;

import it.unicam.cs.model.ContenutoMultimediale;
import it.unicam.cs.repository.ContenutoMultimedialeRepository;

public class VerificaContenutoMultimedialeService {
private final ContenutoMultimedialeRepository contenutoMultimedialeRepository;

    public VerificaContenutoMultimedialeService(ContenutoMultimedialeRepository contenutoMultimedialeRepository) {
        this.contenutoMultimedialeRepository = contenutoMultimedialeRepository;
    }
    public void verificaContenutoMultimediale(ContenutoMultimediale contenutoMultimediale){
    }
    public void validaContenutoMultimediale(ContenutoMultimediale contenutoMultimediale){

    }
    public void invalidaContenutoMultimediale(ContenutoMultimediale contenutoMultimediale){
    }
}
