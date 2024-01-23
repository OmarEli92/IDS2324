package it.unicam.cs.controller;

import it.unicam.cs.model.*;
import it.unicam.cs.service.abstractions.IConsultazioneContenutiService;

import java.util.Map;
import java.util.Optional;

/**Il controller si occupa di gestire la visualizzazione dei contenuti quando un utente richiede di visionare
 * POI,Eventi, Itinerari **/
public class ControllerConsultazioneContenuti {

    private final IConsultazioneContenutiService consultazioneContenutiService;
    private final ListaComuni listaComuni;
    private Comune comune;
    public ControllerConsultazioneContenuti(IConsultazioneContenutiService consultazioneContenutiService,
                                            ListaComuni listaComuni){

        this.consultazioneContenutiService = consultazioneContenutiService;
        this.listaComuni = listaComuni;
    }

    public void selezionaComune(String nomeComune){
        if(listaComuni.getComune(nomeComune) != null){
            comune = listaComuni.getComune(nomeComune);
        }
        else throw new IllegalArgumentException("Il comune non esiste");
    }
    public void visualizzaPOI(int idPOI){
        Optional<POI> poi = Optional.of(consultazioneContenutiService.ottieniPOIdaId(idPOI));
        if(poi.isPresent())
            System.out.println(poi.get().toString());
        else throw new IllegalArgumentException("Il POI non esiste");
    }

    public void visualizzaPOIS(){
        Map<Integer,POI> listaPOI = consultazioneContenutiService.ottieniPOIS(comune.getID());
        for(POI poi : listaPOI.values()){
            System.out.println(poi.toString());
        }
    }

    public void visualizzaEvento(int idEvento){
        Optional<Evento> evento = Optional.of(consultazioneContenutiService.ottieniEventoDaId(idEvento));
        if(evento.isPresent())
            System.out.println(evento.get().toString());
    }

    public void visualizzaEventi(){
        Map<Integer,Evento> eventi = consultazioneContenutiService.ottieniEventi(comune.getID());
        for(Evento evento : eventi.values()){
            System.out.println(evento.toString());
        }
    }

    public void visualizzaItinerario(int idItinerario){
        Optional<Itinerario> itinerario = Optional.of(consultazioneContenutiService.ottieniItinerarioDaId(idItinerario));
        if(itinerario.isPresent())
            System.out.println(itinerario.get().toString());
    }

    public void visualizzaItinerari(){
        Map<Integer,Itinerario> itinerari = consultazioneContenutiService.ottieniItinerari(comune.getID());
        for(Itinerario itinerario : itinerari.values()){
            System.out.println(itinerario.toString());
        }
    }

}
