package it.unicam.cs.controller;

import it.unicam.cs.model.Contest;
import it.unicam.cs.model.Utente;
import it.unicam.cs.service.Interfaces.IContestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:63342")
@RestController("api/contest")
public class ControllerContest {
    private final IContestService contestService;
    @Autowired
    public ControllerContest(IContestService contestService) {
        this.contestService = contestService;
    }

    /**
     * Metodo che permette di creare un contest
     * @param contest contest da creare
     * @return contest creato
     */
    @PostMapping("/animatore/creaContest")
    public ResponseEntity<Object> creaContest(@RequestBody Contest contest){
        if(contestService.ottieniContest(contest.getId())!= null)
            return new ResponseEntity<>("Contest già esistente", HttpStatus.BAD_REQUEST);
        contestService.aggiungiContest(contest);
        return new ResponseEntity<>("Contest creato", HttpStatus.CREATED);
    }

    /**
     * Metodo che permette di rimuovere un contest
     * @param id id del contest da rimuovere
     * @param contest contest da rimuovere
     * @return contest rimosso
     */
    @PutMapping(value="/animatore/rimuoviContest{id}")
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
     * @param partecipanti che partecipano al contest
     * @param idContest
     */
    @PutMapping(value="/animatore/invita{idContest}")
    public ResponseEntity<Object> invitaPartecipanti(@RequestBody List<Utente> partecipanti,
                                                     @PathVariable Integer idContest) {
        if(contestService.aggiungiPartecipanti(idContest,partecipanti))
            return new ResponseEntity<>("Partecipanti invitati", HttpStatus.OK);
        else
            return new ResponseEntity<>("Non sono stati invitati i partecipanti",HttpStatus.BAD_REQUEST);
    }

}
