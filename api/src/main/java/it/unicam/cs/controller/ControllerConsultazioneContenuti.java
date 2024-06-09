package it.unicam.cs.controller;
import it.unicam.cs.model.*;
import it.unicam.cs.model.DTO.PoiDto;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.proxy.ProxyService;
import it.unicam.cs.service.Interfaces.IConsultazioneContenutiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Proxy;
import java.util.List;

/**Il controller si occupa di gestire la visualizzazione dei contenuti quando un utente richiede di visionare
 * POI,Eventi, Itinerari **/
@CrossOrigin(origins = "http://localhost:63342")
@RestController @RequestMapping(value = "/api/comune")
public class ControllerConsultazioneContenuti {

    private final IConsultazioneContenutiService consultazioneContenutiService;
    private Integer IDcomuneSelezionato;
    @Autowired
    public ControllerConsultazioneContenuti(IConsultazioneContenutiService consultazioneContenutiService,
                                            ProxyService proxyService){
        this.consultazioneContenutiService = consultazioneContenutiService;
    }

@GetMapping(value="/{comune}")
    public ResponseEntity<Object> selezionaComune(@PathVariable("comune") String nomeComune){
        Comune comune = consultazioneContenutiService.ottieniComune(nomeComune);
        if(comune !=null){
            this.IDcomuneSelezionato = comune.getId();
            return new ResponseEntity<>("Comune selezionato", HttpStatus.OK);
        }
    return new ResponseEntity<>("Non valido!", HttpStatus.BAD_REQUEST);
    }


  @GetMapping(value="/poi/{idPOI}")
    public ResponseEntity<Object> visualizzaPOI(@PathVariable("idPOI") Integer idPOI){
        return new ResponseEntity<>(consultazioneContenutiService.ottieniPOIdaId(idPOI),HttpStatus.OK);
    }

    @GetMapping(value="/poi")
    public ResponseEntity<Object> visualizzaPOIS(){
      List<PoiDto> pois = consultazioneContenutiService.ottieniPOIS(IDcomuneSelezionato);
      if(pois.isEmpty())
          return new ResponseEntity<>("Nessun POI trovato",HttpStatus.NOT_FOUND);
      return new ResponseEntity<>(pois,HttpStatus.OK);
    }

    @GetMapping(value="/evento/{idEvento}")
    public ResponseEntity<Object> visualizzaEvento(@PathVariable("idEvento") Integer idEvento){
        return new ResponseEntity<>(consultazioneContenutiService.ottieniEventoDaId(idEvento),HttpStatus.OK);
    }

    @GetMapping(value="/eventi")
    public ResponseEntity<Object> visualizzaEventi(){
        return new ResponseEntity<>(consultazioneContenutiService.ottieniEventi(IDcomuneSelezionato),HttpStatus.OK);
    }
    @GetMapping(value="/itinerario/{idItinerario}")
    public ResponseEntity<Object> visualizzaItinerario(@PathVariable("idItinerario") Integer idItinerario){
       return new ResponseEntity<>(consultazioneContenutiService.ottieniItinerarioDaId(idItinerario),HttpStatus.OK);
    }

    @GetMapping(value="/itinerari")
    public ResponseEntity<Object> visualizzaItinerari(){
        return new ResponseEntity<>(consultazioneContenutiService.ottieniItinerari(IDcomuneSelezionato),HttpStatus.OK);
    }


}

