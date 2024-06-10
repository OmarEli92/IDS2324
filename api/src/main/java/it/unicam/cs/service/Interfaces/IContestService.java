package it.unicam.cs.service.Interfaces;

import it.unicam.cs.model.Contest;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.contenuti.ContenutoContest;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Interfaccia service che espone i metodi per la gestione dei contest
 */
public interface IContestService {
    /**
     * Metodo che permette di aggiungere un contest
     * @param contest contest da aggiungere
     */
    void aggiungiContest(Contest contest);
    /**
     * Metodo che permette di rimuovere un contest
     * @param contest contest da rimuovere
     */
    void rimuoviContest(Contest contest);

    /**
     * Metodo che permette di ottenere un contest a partire dal suo id
     * @param id id del contest
     * @return contest
     */
    Contest ottieniContest(Integer id);

    /**
     * Metodo che permette di ottenere tutti i contest
     * @return lista di contest
     */
    List<Contest> ottieniContests();

    /** Metodo che permette di aggiungere i partecipanti**/
    void aggiungiPartecipanti(Integer idContest,List<Integer> idPartecipanti, Integer userId);


    /**Assegna il vincitore del contest**/
    void assegnaVincitoreContest(Contest contest, Utente utente, ContenutoContest contenutoContest);


    /**L'animatore visiona i contenuti caricati per poi decidere il vincitore**/
    Page<ContenutoContest> visionaContenutiCaricati(Integer idContest, int page, int size);

    void aggiungiContenutoContest(Integer idContest, ContenutoContest contenutoContest);

    public void aggiornaListaContenutoContest(Integer idContest, boolean validato);

    /**Chiudi il contest**/
    void chiudiContest(Contest contest);
    /**apri il contest**/
    void apriContest(Contest contest);
}
