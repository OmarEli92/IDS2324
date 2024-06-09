package it.unicam.cs.controller;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Utente;
import it.unicam.cs.proxy.ProxyService;
import it.unicam.cs.service.Interfaces.IGestionePiattaformaService;
import it.unicam.cs.service.Interfaces.IUtenteService;
import it.unicam.cs.service.OSMService;
import it.unicam.cs.util.info.Posizione;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController @RequestMapping(value="api/Amministrazione/")
public class ControllerGestionePiattaforma {

    private final IGestionePiattaformaService gestionePiattaformaService;
    private final IUtenteService utenteService;
    public ControllerGestionePiattaforma(IGestionePiattaformaService gestionePiattaformaService,
                                         IUtenteService utenteService){
        this.gestionePiattaformaService = gestionePiattaformaService;
        this.utenteService = utenteService;
    }

    @GetMapping(value="comuni")
    public ResponseEntity<Object> ottieniComuni(){
        return new ResponseEntity<>(gestionePiattaformaService.ottieniComuni(0,50), HttpStatus.OK);
    }
    @GetMapping(value="comune/{idComune}")
    public ResponseEntity<Object> ottieniComune(@PathVariable("idComune") int idComune){
        return new ResponseEntity<>(gestionePiattaformaService.ottieniComune(idComune),HttpStatus.OK);
    }

    @GetMapping(value="comune/{nome}")
    public ResponseEntity<Object> ottieniComune(@PathVariable("nome") String nome){
        return new ResponseEntity<>(gestionePiattaformaService.ottieniComune(nome),HttpStatus.OK);
    }

    @PostMapping(value="registra")
    public ResponseEntity<Object> aggiungiComune(@RequestBody Comune comune){
        if(gestionePiattaformaService.ottieniComune(comune.getId())!= null) {

            return new ResponseEntity<>("Comune già registrato", HttpStatus.BAD_REQUEST);
        }
        gestionePiattaformaService.aggiungiComune(comune);
        return new ResponseEntity<>("Comune registrato", HttpStatus.CREATED);
    }

    @PostMapping(value="aggiungi_Gestore")
    public ResponseEntity<Object> aggiungiGestoreComune(@RequestBody String nomeComune, int idGestoreComune){
        Comune comune = gestionePiattaformaService.ottieniComune(nomeComune).orElse(null);
        if(comune == null) {
            return new ResponseEntity<>("Il comune non è registrato", HttpStatus.BAD_REQUEST);
        }
        Utente gestoreComune = utenteService.ottieniUtente(idGestoreComune);
        if(gestoreComune == null){
            return new ResponseEntity<>("Nessun utente registrato con quell'id", HttpStatus.BAD_REQUEST);
        }
        gestionePiattaformaService.aggiungiGestoreComune(gestoreComune,nomeComune);
        return new ResponseEntity<>("Gestore piattaforma assegnato al comune", HttpStatus.CREATED);
    }
}
