package it.unicam.cs.service.Interfaces;

import it.unicam.cs.model.Contest;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.model.contenuti.Itinerario;

public interface IComuneService {
    public void aggiungiPOI(Integer idComune, POI poi);
    public void aggiungiItinerario(Integer idComune, Itinerario itinerario);
    public void aggiungiEvento(Integer idComune, Evento evento);
    public void aggiungiContenutoMultimediale(Integer idComune, ContenutoMultimediale contenutoMultimediale);
    public void aggiungiContest(Integer idComune, Contest contest);
    public void aggiornaListaPOI(Integer idPOI, boolean validato);
    public void aggiornaListaItinerario(Integer idItinerario, boolean validato);
    public void aggiornaListaEvento(Integer idEvento, boolean validato);
    public void aggiornaListaContenutiMultimediali(Integer idContenuto, boolean validato);
    public void aggiornaListaContenutiMultimedialiSegnalati(Integer id);
    public void accettaSegnalazioneContenuto(Integer idContenutoMultimediale, boolean eliminato);
    public void aggiornaListaEventiDaAprire(Integer idEvento);
    public void aggiornaListaEventiDaChiudere(Integer idEvento);

    void aggiungiUtente(Integer idUtente, Integer idComune);
}
