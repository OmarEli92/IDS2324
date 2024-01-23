package it.unicam.cs.util;

import it.unicam.cs.model.*;

import java.util.List;

public class ControllerInserimentoContenuti  {

    private List<Comune> comuni;


    public ControllerInserimentoContenuti(List<Comune> comuni) {
        this.comuni = comuni;
    }

    public List<Comune> getComuni() {
        return comuni;
    }

    public void inserisciPOI(Comune comune,POI poi,Utente utente){
        if(comune.getPOIS().contains(poi))
            throw new IllegalArgumentException("POI già esistente");
        for (POI punto: comune.getPOIS()){
            if(punto.getPosizione().equals(poi.getPosizione()))
                throw new IllegalArgumentException("già presente un altro POI in questa posizione");
        }
        utente.inserisciPOI(poi,comune);
    }
    public void inserisciEvento(Comune comune, Evento evento, Utente utente){
        if(comune.getEventi().contains(evento))
            throw new IllegalArgumentException("Evento già creato");
        for(Evento evento1:comune.getEventi()){
            if(evento1.getPoiAssociato().getPosizione().equals(evento1.getPoiAssociato().getPosizione()))
                throw new IllegalArgumentException("già presente un evento in questa posizione");
        }
        utente.inserisciEvento(evento,comune);
    }
    public void inserisciItinerario(Comune comune, Itinerario itinerario, Utente utente){
        if(comune.getItinerari().contains(itinerario))
            throw new IllegalArgumentException("Itinerario già creato");
        utente.inserisciItinerario(itinerario,comune);
    }
    public void inserisciContenutoMultimediale(Comune comune, ContenutoMultimediale contenutoMultimediale, Utente utente){
        if(contenutoMultimediale.getPoiAssociato().getContenutiMultimediali().contains(contenutoMultimediale))
            throw new IllegalArgumentException("contenuto multimediale già presente");
        utente.InserisciContenutoMultimediale(contenutoMultimediale,comune);
    }
}
