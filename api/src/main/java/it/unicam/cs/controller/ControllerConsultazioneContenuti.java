package it.unicam.cs.controller;
import it.unicam.cs.model.*;
import it.unicam.cs.model.DTO.input.PoiDto;
import it.unicam.cs.model.DTO.mappers.EventoDtoMapper;
import it.unicam.cs.model.DTO.mappers.ItinerarioDtoMapper;
import it.unicam.cs.model.DTO.mappers.PoiDtoMapper;
import it.unicam.cs.model.DTO.output.PoiOutpuDto;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.proxy.ProxyService;
import it.unicam.cs.service.Interfaces.IConsultazioneContenutiService;
import lombok.AllArgsConstructor;
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
    private final ProxyService proxyService;
    private Integer IDcomuneSelezionato;
    private final PoiDtoMapper poiDtoMapper;
    private final ItinerarioDtoMapper itinerarioDtoMapper;
    private final EventoDtoMapper eventoDtoMapper;
    @Autowired
    public ControllerConsultazioneContenuti(IConsultazioneContenutiService consultazioneContenutiService,
                                            ProxyService proxyService, PoiDtoMapper poiDtoMapper, ItinerarioDtoMapper itinerarioDtoMapper,
                                            EventoDtoMapper eventoDtoMapper){
        this.consultazioneContenutiService = consultazioneContenutiService;
        this.proxyService = proxyService;
        this.poiDtoMapper = poiDtoMapper;
        this.itinerarioDtoMapper = itinerarioDtoMapper;
        this.eventoDtoMapper = eventoDtoMapper;
    }

    @GetMapping(value="/home")
    public ResponseEntity<Object> home(){
        return new ResponseEntity<>("benvenuto nella home", HttpStatus.OK);
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
      List<PoiOutpuDto> pois = consultazioneContenutiService.ottieniPOIS(IDcomuneSelezionato);
      if(pois.isEmpty())
          return new ResponseEntity<>("Nessun POI trovato",HttpStatus.NOT_FOUND);
      return new ResponseEntity<>(pois,HttpStatus.OK);
    }

    @GetMapping(value="/evento/{idEvento}")
    public ResponseEntity<Object> visualizzaEvento(@PathVariable("idEvento") Integer idEvento){
        Evento evento = consultazioneContenutiService.ottieniEventoDaId(idEvento);
        return new ResponseEntity<>(eventoDtoMapper.apply(evento),HttpStatus.OK);
    }

    @GetMapping(value="/eventi")
    public ResponseEntity<Object> visualizzaEventi(){
        return new ResponseEntity<>(consultazioneContenutiService.ottieniEventi(IDcomuneSelezionato),HttpStatus.OK);
    }
    @GetMapping(value="/itinerario/{idItinerario}")
    public ResponseEntity<Object> visualizzaItinerario(@PathVariable("idItinerario") Integer idItinerario){
        Itinerario itinerario = consultazioneContenutiService.ottieniItinerarioDaId(idItinerario);
        return new ResponseEntity<>(itinerarioDtoMapper.apply(itinerario), HttpStatus.OK);
        //return new ResponseEntity<>(consultazioneContenutiService.ottieniItinerarioDaId(idItinerario),HttpStatus.OK);
    }

    @GetMapping(value="/itinerario")
    public ResponseEntity<Object> visualizzaItinerari(){
        return new ResponseEntity<>(consultazioneContenutiService.ottieniItinerari(IDcomuneSelezionato).stream(),HttpStatus.OK);
    }
    @GetMapping(value = "/territorio")
    public ResponseEntity<Object> visualizzaTerritorioComune(String comune){
        return new ResponseEntity<>(proxyService.ottieniPerimetro(comune), HttpStatus.OK);
    }


}

