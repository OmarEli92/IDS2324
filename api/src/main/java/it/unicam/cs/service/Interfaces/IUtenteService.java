package it.unicam.cs.service.Interfaces;

import it.unicam.cs.model.DTO.UtenteDto;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import jakarta.validation.constraints.Null;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUtenteService {
    /**Aggiunge un utente
     * @param utente**/
    Utente salvaUtente(Utente utente);
    /**Aggiunge un ruolo
     * @param ruolo **/
    Ruolo salvaRuolo(Ruolo ruolo);
    /**Assegna un ruolo all'utente
     * @param ruolo
     * @param username **/
    void assegnaRuoloAutente(String username, String ruolo);
    /** Ottieni utente tramite username
     * @param username **/
    Utente ottieniUtente(String username) throws NullPointerException;
    /**Ottieni utenti
     * @param pageNo
     * @param pageSize **/
    List<UtenteDto> ottieniUtenti(int pageNo, int pageSize);
    /** Ottini ruoli dell'utente
     * @param utente **/
    List<Ruolo> ottieniRuoliUtente(String utente);
    UserDetailsService userDetailsService();
    /** Rimuove un utente**/
    void rimuoviUtente(Utente utente);

}
