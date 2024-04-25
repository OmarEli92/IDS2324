package it.unicam.cs.util;

import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.Itinerario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VerificaSomiglianzaContenuti {

    public boolean verificaSomiglianzaPOI(POI poi, List<POI> pois){
        for (POI p : pois) {
            if (poi.getNome().equalsIgnoreCase(p.getNome()) && poi.getComuneAssociato().equals(p.getComuneAssociato()) && p != poi)
                return true;
        }
        return false;
    }
    public boolean verificaSomiglianzaItinerario(Itinerario itinerario, List<Itinerario> itinerarioList){
        for (Itinerario t : itinerarioList){
            if(itinerario.getNome().equalsIgnoreCase(t.getNome()) && itinerario.getPoisAssociati().equals(t.getPoisAssociati())){
                return true;
            }
        }
        return false;
    }
    public boolean verificaSomiglianzaEvento(Evento evento, List<Evento> eventoList){
        for (Evento e : eventoList){
            if(evento.getNome().equalsIgnoreCase(e.getNome()) && evento.getPoiAssociato().equals(e.getPoiAssociato())){
                return true;
            }
        }
        return false;
    }
}
