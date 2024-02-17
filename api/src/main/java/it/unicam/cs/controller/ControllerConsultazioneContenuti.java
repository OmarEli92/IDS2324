package it.unicam.cs.controller;
import it.unicam.cs.model.*;
import it.unicam.cs.service.Interfaces.IConsultazioneContenutiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**Il controller si occupa di gestire la visualizzazione dei contenuti quando un utente richiede di visionare
 * POI,Eventi, Itinerari **/
@CrossOrigin(origins = "http://localhost:63342")
@RestController
public class ControllerConsultazioneContenuti {

    private final IConsultazioneContenutiService consultazioneContenutiService;
    private final ListaComuni listaComuni;
    private Integer IDcomuneSelezionato;
    @Autowired
    public ControllerConsultazioneContenuti(IConsultazioneContenutiService consultazioneContenutiService,
                                            ListaComuni listaComuni){

        this.consultazioneContenutiService = consultazioneContenutiService;
        this.listaComuni = listaComuni;
    }
/*
@GetMapping(value="/")
    public ResponseEntity<Object> selezionaComune(String nomeComune){
        if(listaComuni.getComune(nomeComune) != null){
            this.IDcomuneSelezionato = listaComuni.getComune(nomeComune).getId();
            return new ResponseEntity<>("Comune selezionato", HttpStatus.OK);
        }
    return new ResponseEntity<>("Comune non trovato!", HttpStatus.BAD_REQUEST);
    }
*/

  @GetMapping(value="/poi/{idPOI}")
    public ResponseEntity<Object> visualizzaPOI(@PathVariable("idPOI") Integer idPOI){
        return new ResponseEntity<>(consultazioneContenutiService.ottieniPOIdaId(idPOI),HttpStatus.OK);
    }

    @GetMapping(value="/poi")
    public ResponseEntity<Object> visualizzaPOIS(){
        return new ResponseEntity<>(consultazioneContenutiService.ottieniPOIS(IDcomuneSelezionato),HttpStatus.OK);
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

    @GetMapping(value="/itinerario")
    public ResponseEntity<Object> visualizzaItinerari(){
        return new ResponseEntity<>(consultazioneContenutiService.ottieniItinerari(IDcomuneSelezionato),HttpStatus.OK);
    }
}

