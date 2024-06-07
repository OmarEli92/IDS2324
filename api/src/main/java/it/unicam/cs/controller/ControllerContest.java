package it.unicam.cs.controller;

import it.unicam.cs.model.Contest;
import it.unicam.cs.model.DTO.input.ContenutoContestDto;
import it.unicam.cs.model.DTO.input.ContestDto;
import it.unicam.cs.model.DTO.input.RichiestaValidazioneDto;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.contenuti.ContenutoContest;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.security.JwtAuthenticationFilter;
import it.unicam.cs.security.JwtService;
import it.unicam.cs.security.Token;
import it.unicam.cs.service.CaricamentoService.CaricamentoContenutoContestService;
import it.unicam.cs.service.CaricamentoService.CaricamentoContestService;
import it.unicam.cs.service.Interfaces.IContestService;
import it.unicam.cs.service.ValidazioneContenutiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:63342")
@RestController("api/contest")
public class ControllerContest {
    private final IContestService contestService;
    private final CaricamentoContestService caricamentoContestService;
    private final CaricamentoContenutoContestService caricamentoContenutoContestService;
    private final ValidazioneContenutiService validazioneContenutiService;
    private final JwtService jwtService;
    @Autowired
    public ControllerContest(IContestService contestService, CaricamentoContestService caricamentoContestService, CaricamentoContenutoContestService caricamentoContenutoContestService,
                             ValidazioneContenutiService validazioneContenutiService, JwtService jwtService) {
        this.contestService = contestService;
        this.caricamentoContestService = caricamentoContestService;
        this.caricamentoContenutoContestService = caricamentoContenutoContestService;
        this.validazioneContenutiService = validazioneContenutiService;
        this.jwtService = jwtService;
    }

    /**
     * Metodo che permette di creare un contest
     * @param contestDto contest da creare
     * @return contest creato
     */
    @PostMapping("/creaContest")
    public ResponseEntity<Object> creaContest(@RequestBody ContestDto contestDto){
        caricamentoContestService.caricaContest(contestDto);
        return new ResponseEntity<>("Contest creato", HttpStatus.CREATED);
    }

    /**
     * metodo che permette di aggiungere un contenuto al contest
     * @param contenutoContestDto contenuto del contest da creare
     * @return contenuto contest creato
     */
    @PostMapping(value = "/aggiungi_contenuto_contest")
    public ResponseEntity<Object> aggiungiContenutoContest(@RequestBody ContenutoContestDto contenutoContestDto){
        caricamentoContenutoContestService.caricaContenutoContest(contenutoContestDto);
        return new ResponseEntity<>("contenuto contest creato", HttpStatus.CREATED);
    }
    @PutMapping(value = "/valida_contenuto_contest")
    public ResponseEntity<Object> validaContenutoContest(@RequestBody RichiestaValidazioneDto richiestaValidazioneDto){
        /*Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String token = (String) authentication.getCredentials();
        String id = jwtService.estraiId(token);*/
        validazioneContenutiService.validaContenutoContest(richiestaValidazioneDto);
        if(richiestaValidazioneDto.isValidato()){
            return new ResponseEntity<>("contenuto contest validato", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("contenuto contest eliminato", HttpStatus.OK);
        }
    }
    /**
     * Metodo che permette di rimuovere un contest
     * @param id id del contest da rimuovere
     * @param contest contest da rimuovere
     * @return contest rimosso
     */
    @PutMapping(value="/rimuoviContest{id}")
    public ResponseEntity<Object> rimuoviContest(@PathVariable Integer id,@RequestBody Contest contest){
        if(contestService.ottieniContest(id)!= null)
            return new ResponseEntity<>("Contest non presente", HttpStatus.BAD_REQUEST);
        contestService.rimuoviContest(contest);
        return new ResponseEntity<>("Contest rimosso", HttpStatus.OK);
    }

        /**
         * Metodo che permette di ottenere un contest a partire dal suo id
         * @param id id del contest
         * @return contest
         */
    @GetMapping(value="/contest/{id}")
    public ResponseEntity<Object> getContest(@PathVariable Integer id){
        Contest contest = contestService.ottieniContest(id);
        if(contest == null)
            return new ResponseEntity<>("Contest non presente", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(contest, HttpStatus.OK);
    }

    /***
     * Metodo che permette di ottenere tutti i contest presenti
     * @return lista di contest
     */
    @GetMapping(value="/contests")
    public ResponseEntity<Object> getContest(){
        List<Contest> contests = contestService.ottieniContests();
        if(contests.isEmpty())
            return new ResponseEntity<>("Nessun contest presente", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(contests, HttpStatus.OK);
    }


    /***
     * Metodo che permette di invitare i partecipanti  al contest
     * @param idPartecipanti id degli utenti da aggiungere al contest
     * @param idContest
     * @return partcepianti aggiunti
     */
    @PutMapping(value="/invita/{idContest}")
    public ResponseEntity<Object> invitaPartecipanti(@RequestBody List<Integer> idPartecipanti,
                                                     @PathVariable Integer idContest) {
        contestService.aggiungiPartecipanti(idContest, idPartecipanti);
        return new ResponseEntity<>("utenti aggiunti", HttpStatus.OK);
    }

    /** Metodo che ottiene tutti i contenuti multimediali del contest
     * @param idContest
     * @param page
     * @param size **/
    @GetMapping(value = "/visualizza_contenuti/{idContest}")
    public ResponseEntity<Page<ContenutoContest>> visualizzaContenuti(@PathVariable Integer idContest,
                                                                      @RequestParam(value = "page", defaultValue = "0") int page,
                                                                      @RequestParam(value = "size", defaultValue = "50") int size){
        return new ResponseEntity<>(contestService.visionaContenutiCaricati(idContest,page,size),HttpStatus.OK);
    }
}
