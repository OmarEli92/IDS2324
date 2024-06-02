package it.unicam.cs.controller;

import it.unicam.cs.model.DTO.UtenteDto;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.repository.IRuoloRepository;
import it.unicam.cs.service.Interfaces.IUtenteService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController @RequestMapping(value = "/api/utenti")
public class ControllerUtenti {
    private final IUtenteService utenteService;

    public ControllerUtenti(IUtenteService utenteService) {
        this.utenteService = utenteService;
    }

    @PreAuthorize("hasRole('Gestore_Comune') or hasRole('Gestore_Piattaforma')")
    @GetMapping(value = "/all")
    public ResponseEntity<List<UtenteDto>> ottieniUtenti(){
        return new ResponseEntity<>(utenteService.ottieniUtenti(0,50), HttpStatus.OK);
    }

    @PreAuthorize("HasRole(Gestore_Piattaforma) or hasRole('Gestore_Comune') ")
    @GetMapping(value = "/{username}")
    public ResponseEntity<Utente> ottieniUtente(@PathVariable(value = "username") String username){
        return new ResponseEntity<>(utenteService.ottieniUtente(username),HttpStatus.OK);
    }

    @PreAuthorize("hasRole('Gestore_Comune') or hasRole('Gestore_Piattaforma')")
    @PostMapping(value = "/aggiungi")
    public ResponseEntity<Utente> aggiungiUtente(@RequestBody Utente utente){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().
                                path("/api/utenti/aggiungi").toUriString());
        return ResponseEntity.created(uri).body(utenteService.salvaUtente(utente));
    }

    @PreAuthorize("hasRole('Gestore_Comune') or hasRole('Gestore_Piattaforma')")
    @DeleteMapping(value = "/rimuovi")
    public ResponseEntity<Object> rimuoviUtente(@RequestBody Utente utente){
        utenteService.rimuoviUtente(utente);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasRole('Gestore_Comune') or hasRole('Gestore_Piattaforma')")
    @PostMapping(value = "/ruolo/aggiungi")
    public ResponseEntity<Ruolo> aggiungiRuolo(@RequestBody Ruolo ruolo){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().
                        path("/api/utenti/ruolo/aggiungi").toUriString());
        return ResponseEntity.created(uri).body(utenteService.salvaRuolo(ruolo));
    }

    @PreAuthorize("hasRole('Gestore_Comune') or hasRole('Gestore_Piattaforma')")
    @PostMapping(value = "/aggiungi_ruolo_utente")
    public ResponseEntity<Object> aggiungiRuoloAUtente(@RequestBody InfoRuoloUtente info){
        utenteService.assegnaRuoloAutente(info.getUsername(),info.getRuolo());
        return ResponseEntity.ok().build();
    }
    @Data
    class InfoRuoloUtente{
        private String username;
        private String ruolo;
    }
}
