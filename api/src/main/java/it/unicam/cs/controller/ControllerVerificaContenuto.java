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

    public void validaPOI (POI poi){
        this.serviceVerificaContenuto.validaPOI(poi);
    }

    public void validaEvento (Evento evento){
    }

    public void validaItinerario (Itinerario itinerario){
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
