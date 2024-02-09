package it.unicam.cs.controller;
import it.unicam.cs.model.*;
import it.unicam.cs.model.Evento;
import it.unicam.cs.model.POI;
import it.unicam.cs.service.Interfaces.IConsultazioneContenutiService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**Il controller si occupa di gestire la visualizzazione dei contenuti quando un utente richiede di visionare
 * POI,Eventi, Itinerari **/
public class ControllerConsultazioneContenuti {

    private final IConsultazioneContenutiService consultazioneContenutiService;
    private final ListaComuni listaComuni;
    private String IDcomuneSelezionato;
    public ControllerConsultazioneContenuti(IConsultazioneContenutiService consultazioneContenutiService,
                                            ListaComuni listaComuni){

        this.consultazioneContenutiService = consultazioneContenutiService;

        this.listaComuni = listaComuni;
    }

    public void selezionaComune(String nomeComune){
        if(listaComuni.getComune(nomeComune) != null){
            this.IDcomuneSelezionato = listaComuni.getComune(nomeComune).getId();
        }
        else throw new IllegalArgumentException("Il comune non esiste");
    }
  
    public void visualizzaPOI(String idPOI){
        Optional<POI> poi = Optional.of(consultazioneContenutiService.ottieniPOIdaId(idPOI));
        if(poi.isPresent())
            System.out.println(poi.get().toString());
        else throw new IllegalArgumentException("Il POI non esiste");
    }

    public void visualizzaPOIS(){
        List<POI> listaPOI = consultazioneContenutiService.ottieniPOIS(IDcomuneSelezionato);
        for(POI poi : listaPOI){
            System.out.println(poi.toString());
        }
    }

    public void visualizzaEvento(String idEvento){
        Optional<Evento> evento = Optional.of(consultazioneContenutiService.ottieniEventoDaId(idEvento));
        if(evento.isPresent())
            System.out.println(evento.get().toString());
    }

    public void visualizzaEventi(){
        List<Evento> eventi = consultazioneContenutiService.ottieniEventi(IDcomuneSelezionato);
        for(Evento evento : eventi){
            System.out.println(evento.toString());
        }
    }

    public void visualizzaItinerario(String idItinerario){
        Optional<Itinerario> itinerario = Optional.of(consultazioneContenutiService.ottieniItinerarioDaId(idItinerario));
        if(itinerario.isPresent())
            System.out.println(itinerario.get().toString());
    }

    public void visualizzaItinerari(){
        List<Itinerario> itinerari = consultazioneContenutiService.ottieniItinerari(IDcomuneSelezionato);

        for(Itinerario itinerario : itinerari){
            System.out.println(itinerario.toString());
        }
    }

 
}

