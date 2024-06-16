package it.unicam.cs.controller;
import it.unicam.cs.model.*;
import it.unicam.cs.model.DTO.input.PoiDto;
import it.unicam.cs.model.DTO.mappers.*;
import it.unicam.cs.model.DTO.output.PoiOutpuDto;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.proxy.ProxyService;
import it.unicam.cs.service.Interfaces.IConsultazioneContenutiService;
import it.unicam.cs.service.Interfaces.IContestService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Proxy;
import java.util.List;
import java.util.stream.Collectors;

/**Il controller si occupa di gestire la visualizzazione dei contenuti quando un utente richiede di visionare
 * POI,Eventi, Itinerari **/
@CrossOrigin(origins = "http://localhost:63342")
@RestController @RequestMapping(value = "/api/comune")
public class ControllerConsultazioneContenuti {

    private final IConsultazioneContenutiService consultazioneContenutiService;
    private Integer IDcomuneSelezionato;
    private final PoiDtoMapper poiDtoMapper;
    private final ItinerarioDtoMapper itinerarioDtoMapper;
    private final EventoDtoMapper eventoDtoMapper;
    private final ContenutoMultimedialeDtoMapper contenutoMultimedialeDtoMapper;
    private final ProxyService proxyService;
    @Autowired
    public ControllerConsultazioneContenuti(IConsultazioneContenutiService consultazioneContenutiService,
                                            ProxyService proxyService, PoiDtoMapper poiDtoMapper, ItinerarioDtoMapper itinerarioDtoMapper,
                                            ContenutoMultimedialeDtoMapper contenutoMultimedialeDtoMapper, EventoDtoMapper eventoDtoMapper){
        this.consultazioneContenutiService = consultazioneContenutiService;
        this.proxyService = proxyService;
        this.poiDtoMapper = poiDtoMapper;
        this.itinerarioDtoMapper = itinerarioDtoMapper;
        this.eventoDtoMapper = eventoDtoMapper;
        this.contenutoMultimedialeDtoMapper = contenutoMultimedialeDtoMapper;
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
        POI poi = consultazioneContenutiService.ottieniPOIdaId(idPOI);
        return new ResponseEntity<>(poiDtoMapper.apply(poi), HttpStatus.OK);
      //return new ResponseEntity<>(consultazioneContenutiService.ottieniPOIdaId(idPOI),HttpStatus.OK);
    }

    @GetMapping(value="/poiComune")
    public ResponseEntity<Object> visualizzaPOIS(){
      List<POI> pois = consultazioneContenutiService.ottieniPOIS(IDcomuneSelezionato);
      if(pois.isEmpty()) {
          return new ResponseEntity<>("Nessun POI trovato", HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(pois.stream().map(poiDtoMapper), HttpStatus.OK);
    }

    @GetMapping(value="/evento/{idEvento}")
    public ResponseEntity<Object> visualizzaEvento(@PathVariable("idEvento") Integer idEvento){
        Evento evento = consultazioneContenutiService.ottieniEventoDaId(idEvento);
        return new ResponseEntity<>(eventoDtoMapper.apply(evento),HttpStatus.OK);
    }

    @GetMapping(value="/eventi")
    public ResponseEntity<Object> visualizzaEventi(){
        List<Evento> eventi = consultazioneContenutiService.ottieniEventi(IDcomuneSelezionato);
        if(eventi.isEmpty()) {
            return new ResponseEntity<>("Nessun evento trovato", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(eventi.stream().map(eventoDtoMapper),HttpStatus.OK);
    }
    @GetMapping(value="/itinerario/{idItinerario}")
    public ResponseEntity<Object> visualizzaItinerario(@PathVariable("idItinerario") Integer idItinerario){
        Itinerario itinerario = consultazioneContenutiService.ottieniItinerarioDaId(idItinerario);
        return new ResponseEntity<>(itinerarioDtoMapper.apply(itinerario), HttpStatus.OK);
        //return new ResponseEntity<>(consultazioneContenutiService.ottieniItinerarioDaId(idItinerario),HttpStatus.OK);
    }

    @GetMapping(value="/itinerari")
    public ResponseEntity<Object> visualizzaItinerari(){
        List<Itinerario> itinerari = consultazioneContenutiService.ottieniItinerari(IDcomuneSelezionato);
        if(itinerari.isEmpty()) {
            return new ResponseEntity<>("Nessun itinerario trovato", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(itinerari.stream().map(itinerarioDtoMapper),HttpStatus.OK);
    }
    @GetMapping(value = "/territorio")
    public ResponseEntity<Object> visualizzaTerritorioComune(String comune){
        return new ResponseEntity<>(proxyService.ottieniPerimetro(comune), HttpStatus.OK);
    }
    @GetMapping(value = "/contenutoMultimediale/{idContenutoMultimediale}")
    public ResponseEntity<Object> visualizzaContenutoMultimediale(@PathVariable("idContenutoMultimediale") Integer idContenutoMultimediale){
        ContenutoMultimediale contenutoMultimediale = consultazioneContenutiService.ottieniContenutoMultimedialeDaId(idContenutoMultimediale);
        return new ResponseEntity<>(contenutoMultimedialeDtoMapper.apply(contenutoMultimediale), HttpStatus.OK);
    }
    @GetMapping(value = "/contenutiMultimediali")
    public ResponseEntity<Object> visualizzaContenutiMultimediali(){
        List<ContenutoMultimediale> contenutiMultimediali = consultazioneContenutiService.ottieniContenutiMultimedialiComune(IDcomuneSelezionato);
        if(contenutiMultimediali.isEmpty()) {
            return new ResponseEntity<>("Nessun contenuto multimediale trovato", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contenutiMultimediali.stream().map(contenutoMultimedialeDtoMapper), HttpStatus.OK);
    }
}

