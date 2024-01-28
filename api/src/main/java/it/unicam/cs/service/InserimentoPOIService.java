package it.unicam.cs.service;

import it.unicam.cs.model.Contenuto;
import it.unicam.cs.model.POI;
import it.unicam.cs.repository.POIRepositoryImpl;
import it.unicam.cs.service.Interfaces.IInserimentoContenutiService;

public class InserimentoPOIService implements IInserimentoContenutiService {
private POIRepositoryImpl poiRepository;

    public InserimentoPOIService(POIRepositoryImpl poiRepository) {
        this.poiRepository = poiRepository;
    }

    public void aggiugiContenuto(Contenuto poi) {
    this.poiRepository.aggiungiPOI((POI)poi);
    }

    public void aggiugiContenutoInPending(Contenuto poi) {
    this.poiRepository.aggiungiPOIInPending((POI)poi);
    }
}
