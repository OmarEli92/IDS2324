package it.unicam.cs.controller;

import it.unicam.cs.exception.POINotFoundException;
import it.unicam.cs.model.*;
import it.unicam.cs.service.abstractions.IInserimentoContenutiService;

import java.util.List;

public class ControllerInserimentoContenuti  {

    private IInserimentoContenutiService inserimentoContenutiService;

    public ControllerInserimentoContenuti(IInserimentoContenutiService inserimentoContenutiService) {
        this.inserimentoContenutiService = inserimentoContenutiService;
    }

   /* public List<Comune> getComuni() {
        return comuni;
    }

    public void inserisciPOI(Comune comune,POI poi,Utente utente){
        if(comune.getPOIS().contains(poi))
            throw new IllegalArgumentException("POI già esistente");
        for (POI punto: comune.getPOIS()){
            if(punto.getPosizione().equals(poi.getPosizione()))
                throw new IllegalArgumentException("già presente un altro POI in questa posizione");
        }
        //utente.inserisciPOI(poi,comune);
    }
    public void inserisciEvento(Comune comune, Evento evento, Utente utente){
        if(comune.getEventi().contains(evento))
            throw new IllegalArgumentException("Evento già creato");
        for(Evento evento1:comune.getEventi()){
            if(evento1.getPoiAssociato().getPosizione().equals(evento1.getPoiAssociato().getPosizione()))
                throw new IllegalArgumentException("già presente un evento in questa posizione");
        }
        //utente.inserisciEvento(evento,comune);
    }
    public void inserisciItinerario(Comune comune, Itinerario itinerario, Utente utente){
        if(comune.getItinerari().contains(itinerario))
            throw new IllegalArgumentException("Itinerario già creato");
        //utente.inserisciItinerario(itinerario,comune);
    }
    public void inserisciContenutoMultimediale(Comune comune, ContenutoMultimediale contenutoMultimediale, Utente utente){
        if(contenutoMultimediale.getPoiAssociato().getContenutiMultimediali().contains(contenutoMultimediale))
            throw new IllegalArgumentException("contenuto multimediale già presente");
        //utente.InserisciContenutoMultimediale(contenutoMultimediale,comune);
    }*/
   /* public void inserisciPOI(Utente utente, POI poi) throws POINotFoundException {
        inserimentoContenutiService.aggiungiPOI(poi);
    }
    public void inserisciEvento(Evento evento){
        inserimentoContenutiService.aggiungiEvento(evento);
    }
    public void InserisciItinerario(Itinerario itinerario) throws POINotFoundException {
        inserimentoContenutiService.aggiungiItinerario(itinerario);
    }
    public void InserisciContenutoMultimediale(ContenutoMultimediale contenutoMultimediale){
        inserimentoContenutiService.aggiungiContenutoMultimediale(contenutoMultimediale);
    }*/
}
