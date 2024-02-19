package it.unicam.cs.model.DesignPatterns;

import it.unicam.cs.model.Contenuto;
import it.unicam.cs.model.POI;
import it.unicam.cs.repository.IPOIRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class InserimentoPOI implements Inserimento {
    @Autowired
    private IPOIRepository poiRepository;

    @Override
    public void insert(Contenuto poi) {
        this.poiRepository.save((POI)poi);
    }
}
