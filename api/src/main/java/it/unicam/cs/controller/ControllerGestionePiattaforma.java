package it.unicam.cs.controller;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.DTO.input.ComuneDto;
import it.unicam.cs.model.DTO.input.ComuneGestoreDto;
import it.unicam.cs.model.DTO.mappers.ComuneDtoMapper;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.proxy.ProxyService;
import it.unicam.cs.security.JwtService;
import it.unicam.cs.service.Interfaces.IGestionePiattaformaService;
import it.unicam.cs.service.Interfaces.IUtenteService;
import it.unicam.cs.service.OSMService;
import it.unicam.cs.util.enums.RuoliUtente;
import it.unicam.cs.util.info.Posizione;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.sql.Struct;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController @RequestMapping(value="api/Amministrazione/")
public class ControllerGestionePiattaforma {

    private final IGestionePiattaformaService gestionePiattaformaService;
    private final IUtenteService utenteService;
    private final JwtService jwtService;
    private final ComuneDtoMapper comuneDtoMapper;
    public ControllerGestionePiattaforma(IGestionePiattaformaService gestionePiattaformaService,
                                         IUtenteService utenteService, JwtService jwtService,
                                         ComuneDtoMapper comuneDtoMapper){
        this.gestionePiattaformaService = gestionePiattaformaService;
        this.utenteService = utenteService;
        this.jwtService = jwtService;
        this.comuneDtoMapper = comuneDtoMapper;
    }

    @GetMapping(value="comuni")
    public ResponseEntity<Object> ottieniComuni(){
        return new ResponseEntity<>(gestionePiattaformaService.ottieniComuni(0,50), HttpStatus.OK);
    }
    @GetMapping(value="comune/{idComune}")
    public ResponseEntity<Object> ottieniComune(@PathVariable("idComune") int idComune){
        Comune comune = gestionePiattaformaService.ottieniComune(idComune);
        if(comune == null){
            return new ResponseEntity<>("comune non esistente", HttpStatus.OK);
        }
        return new ResponseEntity<>(comuneDtoMapper.apply(comune),HttpStatus.OK);
    }

    @GetMapping(value="comune/{nome}")
    public ResponseEntity<Object> ottieniComune(@PathVariable("nome") String nome){
        Comune comune = gestionePiattaformaService.ottieniComune(nome);
        if(comune == null){
            return new ResponseEntity<>("comune non esistente", HttpStatus.OK);
        }
        return new ResponseEntity<>(comuneDtoMapper.apply(comune),HttpStatus.OK);
    }

    @PostMapping(value="registra")
    public ResponseEntity<Object> aggiungiComune(@RequestBody ComuneDto comuneDto){
        gestionePiattaformaService.aggiungiComune(comuneDto);
        return new ResponseEntity<>("Comune registrato", HttpStatus.CREATED);
    }

    @PostMapping(value="aggiungi_Gestore")
    public ResponseEntity<Object> aggiungiGestoreComune(@RequestBody ComuneGestoreDto comuneGestoreDto){
        gestionePiattaformaService.aggiungiGestoreComune(comuneGestoreDto.getIdGestoreComune(), comuneGestoreDto.getNomeComune());
        return new ResponseEntity<>("Gestore piattaforma assegnato al comune", HttpStatus.CREATED);
    }
}
