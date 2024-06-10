package it.unicam.cs.service.Interfaces;

import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.model.contenuti.Itinerario;

public interface IItinerarioService {
    public void aggiungiItinerario(Itinerario itinerario);
    public void salvaContenutoMultimediale(ContenutoMultimediale contenutoMultimediale, Integer idItinerario);
    public void validaItinerario(Integer idItinerario, boolean validato);
    public void aggiornaListaContenutoMultimediale(Integer idContenutoMultimediale, boolean validato);
    public void aggiornaListaContenutoMultimedialeDaSegnalare(Integer id);
    public void accettaSegnalazioneContenuto(Integer idContenutoMultimediale, boolean eliminato);
}
