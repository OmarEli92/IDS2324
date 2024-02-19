package it.unicam.cs.model.DesignPatterns;

import it.unicam.cs.model.Contenuto;
import it.unicam.cs.model.POI;
import it.unicam.cs.repository.IPOIInPendingRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class InserimentoPOIInPending implements Inserimento {
    @Autowired
    private IPOIInPendingRepository poiInPendingRepository;

    @Override
    public void insert(Contenuto poi) {
        this.poiInPendingRepository.save((POI)poi);
    }
}
