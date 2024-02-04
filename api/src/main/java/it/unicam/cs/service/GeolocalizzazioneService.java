package it.unicam.cs.service;

import it.unicam.cs.model.Evento;
import it.unicam.cs.model.POI;
import it.unicam.cs.model.Itinerario;
import it.unicam.cs.service.Interfaces.IGeolocalizzazioneService;
import it.unicam.cs.util.Posizione;

import java.util.List;

public class GeolocalizzazioneService implements IGeolocalizzazioneService {
    @Override
    public Posizione getPosizioneComune(String comune) {
        return null;
    }

    @Override
    public void getPosizione() {

    }

    @Override
    public void getIndirizzo() {

    }

    @Override
    public void visualizzaPOI(int idPOI) {

    }

    @Override
    public void visualizzaEvento(int idEvento) {

    }

    @Override
    public void visualizzaItinerario(int idItinerario) {

    }

    @Override
    public void visualizzaPOISComune(List<POI> pois) {

    }

    @Override
    public void visualizzaEventiComune(List<Evento> eventi) {

    }


    @Override
    public void visualizzaItinerari(List<Itinerario> itinerari) {

    }

    @Override
    public void verificaPuntoNelComune(Posizione posizione, String comune) {

    }
}
