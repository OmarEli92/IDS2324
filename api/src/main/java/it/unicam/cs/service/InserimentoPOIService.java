package it.unicam.cs.service;

import it.unicam.cs.model.POI;
import it.unicam.cs.repository.POIRepositoryImpl;

public class InserimentoPOIService {
private POIRepositoryImpl poiRepository;

    public InserimentoPOIService(POIRepositoryImpl poiRepository) {
        this.poiRepository = poiRepository;
    }

    public void aggiugiPOI(POI poi) {
    this.poiRepository.aggiungiPOI(poi);
    }

    public void aggiugiPOIInPending(POI poi) {
    this.poiRepository.aggiungiPOIInPending(poi);
    }
}
