package it.unicam.cs.service.Interfaces;

import it.unicam.cs.model.Contest;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;

public interface IPOIService {
    public void aggiungiPOI(POI poi);
    public void salvaContenutoMultimediale(Integer idPoi, ContenutoMultimediale contenutoMultimediale);
    public void salvaEvento(Integer idPoi, Evento evento);
    public void salvaContest(Integer idPoi, Contest contest);
    public void validaPOI(Integer id, boolean validato);
    public void aggiornaListaEvento(Integer idEvento, boolean validato);
    public void aggiornaListaContenutoMultimediale(Integer idContenutoMultimediale, boolean validato);
    public void aggiornaListaContenutoMultimedialeDaSegnalare(Integer id);
    public void accettaSegnalazioneContenuto(Integer idContenutoMultimediale, boolean eliminato);
    public void aggiornaListaContestDaChiudere(Integer idContest);
    public void aggiornaListaContestAperti(Integer idContest);
    public void aggiornaListaEventiDaAprire(Integer idEvento);
    public void aggiornaListaEventiDaChiudere(Integer idEvento);
}
