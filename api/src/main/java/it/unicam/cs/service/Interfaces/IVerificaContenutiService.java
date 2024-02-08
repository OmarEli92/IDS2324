package it.unicam.cs.service.Interfaces;

import it.unicam.cs.model.Evento;
import it.unicam.cs.model.Itinerario;
import it.unicam.cs.model.POI;

public interface IVerificaContenutiService {

    void verificaPOI(POI poi);
    void validaPOI(POI poi);
    void invalidaPOI(POI itinerario);


}
