package it.unicam.cs.service.Interfaces;

import it.unicam.cs.model.DTO.input.UtenteDto;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
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

    /**
     * ottieni utente tramite id
     *
     * @param id
     * @return Utente utente
     */
    Utente ottieniUtenteById(Integer id);
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

    void aggiornaListaContenutiMultimedialiSegnalati(Integer id);

    void accettaSegnalazioneContenuto(Integer idContenutoMultimediale, boolean eliminato);

    void aggiornaListaContestCreatiAperti(Integer idContest);

    void aggiornaListaContestInPartecipazioneAperti(Integer idContest);

    void aggiornaListaContestCreatiChiusi(Integer idContest);

    void aggiornaListaEventiCreatiDaAprire(Integer idEvento);

    void aggiornaListaEventiCreatiDaChiudere(Integer idEvento);
}
