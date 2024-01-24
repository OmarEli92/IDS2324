package it.unicam.cs.service;

import it.unicam.cs.model.POI;
import it.unicam.cs.repository.POIRepositoryImpl;

public class VerificaPOIService {
private final POIRepositoryImpl poiRepository;

    public VerificaPOIService(POIRepositoryImpl poiRepository) {
        this.poiRepository = poiRepository;
    }
    public void verificaCoordinate(POI poi){
        this.poiRepository.getComune().verificaCoordinate(poi);
    }

    public void verificaPOI(POI poi) {
        this.poiRepository.getCuratore().verificaPOI(poi);
    }

    public void validaPOI(POI poi) {
        this.poiRepository.rimuoviPOIInPending(poi);
        this.poiRepository.aggiungiPOI(poi);
    }
    public void invalidaPOI(POI poi){
        this.poiRepository.rimuoviPOIInPending(poi);
    }
}
