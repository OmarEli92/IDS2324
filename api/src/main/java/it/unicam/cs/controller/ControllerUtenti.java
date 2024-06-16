package it.unicam.cs.controller;

import it.unicam.cs.model.DTO.input.InfoRuoloUtenteDto;
import it.unicam.cs.model.DTO.mappers.UtenteDtoMapper;
import it.unicam.cs.model.DTO.output.UtenteDto;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.security.JwtService;
import it.unicam.cs.service.Interfaces.IUtenteService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController @RequestMapping(value = "/api/utenti")
public class ControllerUtenti {
    private final IUtenteService utenteService;
    private final JwtService jwtService;
    private final UtenteDtoMapper utenteDtoMapper;
    public ControllerUtenti(IUtenteService utenteService, JwtService jwtService, UtenteDtoMapper utenteDtoMapper) {
        this.utenteService = utenteService;
        this.jwtService = jwtService;
        this.utenteDtoMapper = utenteDtoMapper;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<Object> ottieniUtenti(){
        return new ResponseEntity<>(utenteService.ottieniUtenti(0,50).stream()
                .map(utenteDtoMapper), HttpStatus.OK);
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<Utente> ottieniUtente(@PathVariable(value = "username") String username){
        return new ResponseEntity<>(utenteService.ottieniUtente(username),HttpStatus.OK);
    }

    @PostMapping(value = "/aggiungi")
    public ResponseEntity<Utente> aggiungiUtente(@RequestBody Utente utente){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().
                                path("/api/utenti/aggiungi").toUriString());
        return ResponseEntity.created(uri).body(utenteService.salvaUtente(utente));
    }

    @DeleteMapping(value = "/rimuovi")
    public ResponseEntity<Object> rimuoviUtente(@RequestBody Utente utente){
        utenteService.rimuoviUtente(utente);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/ruolo/aggiungi")
    public ResponseEntity<Ruolo> aggiungiRuolo(@RequestBody Ruolo ruolo){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().
                        path("/api/utenti/ruolo/aggiungi").toUriString());
        return ResponseEntity.created(uri).body(utenteService.salvaRuolo(ruolo));
    }

    @PostMapping(value = "/aggiungi_ruolo_utente")
    public ResponseEntity<Object> aggiungiRuoloAUtente(@RequestBody InfoRuoloUtenteDto info, @RequestHeader("Authorization") String authorizationHeader){
        String token = authorizationHeader.substring(7);
        Integer userId = jwtService.estraiId(token);
        utenteService.assegnaRuoloAutente(info.getUsername(),info.getRuolo(), userId);
        return new ResponseEntity<>("ruolo aggiunto all'utente", HttpStatus.OK);
    }
}
