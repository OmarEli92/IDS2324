package it.unicam.cs.controller;

import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.service.ServiceVerificaContenuto;

public class ControllerVerificaContenuto {
    private ServiceVerificaContenuto serviceVerificaContenuto;

    public ControllerVerificaContenuto(ServiceVerificaContenuto serviceVerificaContenuto) {
        this.serviceVerificaContenuto = serviceVerificaContenuto;
    }
    /*
    verifica che le coordinate del POI siano all'interno del comune associato
     */
    public void verificaPOI(POI poi){
        this.serviceVerificaContenuto.verificaPOI(poi);
    }

    public void validaPOI (POI poi){
        this.serviceVerificaContenuto.validaPOI(poi);
    }
    /*
    verifica che nel detrminato periodo dell'evento non ci siano altri eventi
    associati al POI associato
     */
    public void verificaEvento (Evento evento){
    }
    public void validaEvento (Evento evento){
    }

    /*
    verifica che i punti selezionati per l'itinerario siano dei POI
     */
    public void verificaItinerario (Itinerario itinerario){
    }
    public void validaItinerario (Itinerario itinerario){
    }

    /*
    verifica che il contenuto multimediale non sia già stato inserito all'interno del
    POI associato
     */
    public void verificaContenutoMultimediale (ContenutoMultimediale contenutoMultimediale){
    }
    public void validaContenutoMultimediale (ContenutoMultimediale contenutoMultimediale){
    }

    public void invalidaPOI(POI poi){
    }

    public void invalidaEvento (Evento evento){
    }

    public void invalidaItinerario (Itinerario itinerario){
    }

    public void invalidaContenutoMultimediale (ContenutoMultimediale contenutoMultimediale){
    }
}
