package it.unicam.cs.controller;

import it.unicam.cs.model.ContenutoMultimediale;
import it.unicam.cs.model.Evento;
import it.unicam.cs.model.Itinerario;
import it.unicam.cs.model.POI;
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
        this.serviceVerificaContenuto.verificaEvento(evento);
    }
    public void validaEvento (Evento evento){
        this.serviceVerificaContenuto.validaEvento(evento);
    }

    /*
    verifica che i punti selezionati per l'itinerario siano dei POI
     */
    public void verificaItinerario (Itinerario itinerario){
        this.serviceVerificaContenuto.verificaItinerario(itinerario);
    }
    public void validaItinerario (Itinerario itinerario){
        this.serviceVerificaContenuto.validaItinerario(itinerario);
    }

    /*
    verifica che il contenuto multimediale non sia già stato inserito all'interno del
    POI associato
     */
    public void verificaContenutoMultimediale (ContenutoMultimediale contenutoMultimediale){
        this.serviceVerificaContenuto.verificaContenutoMultimediale(contenutoMultimediale);
    }
    public void validaContenutoMultimediale (ContenutoMultimediale contenutoMultimediale){
        this.serviceVerificaContenuto.validaContenutoMultimediale(contenutoMultimediale);
    }

    public void invalidaPOI(POI poi){
        this.serviceVerificaContenuto.invalidaPOI(poi);
    }

    public void invalidaEvento (Evento evento){
        this.serviceVerificaContenuto.invalidaEvento(evento);
    }

    public void invalidaItinerario (Itinerario itinerario){
        this.serviceVerificaContenuto.invalidaItinerario(itinerario);
    }

    public void invalidaContenutoMultimediale (ContenutoMultimediale contenutoMultimediale){
        this.serviceVerificaContenuto.invalidaContenutoMultimediale(contenutoMultimediale);
    }
}
