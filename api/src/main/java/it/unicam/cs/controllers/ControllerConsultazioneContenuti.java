package it.unicam.cs.controllers;

import it.unicam.cs.model.*;

import java.util.List;
import java.util.Map;

/**Il controller si occupa di gestire la visualizzazione dei contenuti quando un utente richiede di visionare
 * POI,Eventi, Itinerari **/
public class ControllerConsultazioneContenuti {
    private final ListaComuni listaComuni;
    private Comune comune;
    public ControllerConsultazioneContenuti(ListaComuni listaComuni){
        this.listaComuni = listaComuni;
    }

    public void selezionaComune(String nomeComune){
        if(listaComuni.getComune(nomeComune) != null){
            comune = listaComuni.getComune(nomeComune);
        }
        else throw new IllegalArgumentException("Il comune non esiste");
    }
    public void visualizzaPOI(int idPOI){

        Map<Integer,POI> listaPOI = ottieniPOIS(comune);
        if(listaPOI.containsKey(idPOI)){
            POI poi = comune.getPOIS().get(idPOI);
        }
        else throw new IllegalArgumentException("Il POI non esiste");
    }

    public void visualizzaPOIS(){
        Map<Integer,POI> pois = ottieniPOIS(comune);
        for(POI poi : pois.values()){
            System.out.println(poi.toString());
        }
    }
    private Map<Integer,POI> ottieniPOIS(Comune comune){
        return comune.getPOIS();
    }

    public void visualizzaEvento(int idEvento){
        Map<Integer,Evento> listaEventi = ottieniEventi(comune);
        if(listaEventi.containsKey(idEvento)){
            Evento evento = comune.getEventi().get(idEvento);
        }
        else throw new IllegalArgumentException("L'evento non esiste");
    }

    public void visualizzaEventi(){
        Map<Integer,Evento> eventi = ottieniEventi(comune);
        for(Evento evento : eventi.values()){
            System.out.println(evento.toString());
        }
    }
    private Map<Integer, Evento> ottieniEventi(Comune comune){
        return comune.getEventi();
    }
    public void visualizzaItinerario(int idItinerario){
        Map<Integer,Itinerario> listaItinerari = ottieniItinerari(comune);
        if(listaItinerari.containsKey(idItinerario)){
            Itinerario itinerario = comune.getItinerari().get(idItinerario);
        }
        else throw new IllegalArgumentException("L'itinerario non esiste");

    }

    public void visualizzaItinerari(){
        Map<Integer,Itinerario> itinerari = ottieniItinerari(comune);
        for(Itinerario itinerario : itinerari.values()){
            System.out.println(itinerario.toString());
        }
    }
    private Map<Integer, Itinerario> ottieniItinerari(final Comune comune){
        return comune.getItinerari();
    }

}
