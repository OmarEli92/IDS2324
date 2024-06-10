package it.unicam.cs.service.Interfaces;

import it.unicam.cs.model.Contest;
import it.unicam.cs.model.DTO.input.UtenteDto;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.ContenutoContest;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.model.contenuti.Itinerario;
import jakarta.transaction.Transactional;
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
    @Transactional
    public void aggiungiPOI(Integer idUtente, POI poi);
    @Transactional
    public void aggiungiItinerario(Integer idUtente, Itinerario itinerario);
    @Transactional
    public void aggiungiContenutoMultimediale(Integer idUtente, ContenutoMultimediale contenutoMultimediale);
    @Transactional
    public void aggiungiEvento(Integer idUtente, Evento evento);
    @Transactional
    public void aggiungiContest(Integer idUtente, Contest contest);
    @Transactional
    public void aggiungiContenutoContest(Integer idUtente, ContenutoContest contenutoContest);
    @Transactional
    public void aggiornaListaPOI(Integer idPOI, boolean validato);
    @Transactional
    public void aggiornaListaItinerario(Integer idItinerario, boolean validato);
    @Transactional
    public void aggiornaListaEvento(Integer idEvento, boolean validato);
    @Transactional
    public void aggiornaListaContenutiMultimediali(Integer idContenutoMultimediale, boolean validato);
    @Transactional
    public void aggiornaListaContenutiContest(Integer idContenutoContest, boolean validato);
    /** Rimuove un utente**/
    void rimuoviUtente(Utente utente);

    void aggiornaListaContenutiMultimedialiSegnalati(Integer id);
    void accettaSegnalazioneContenuto(Integer idContenutoMultimediale, boolean eliminato);

    void aggiornaListaContestCreatiAperti(Integer idContest);

    void aggiornaListaContestInPartecipazioneAperti(Integer idContest);

    void aggiornaListaContestDaChiudere(Integer idContest);

    void aggiornaListaEventiCreatiDaAprire(Integer idEvento);

    void aggiornaListaEventiCreatiDaChiudere(Integer idEvento);

    Utente ottieniUtente(Integer id);

}
