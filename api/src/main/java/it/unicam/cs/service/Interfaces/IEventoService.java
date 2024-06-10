package it.unicam.cs.service.Interfaces;

import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;

public interface IEventoService {
    public void aggiungiEvento(Evento evento);
    public void salvaContenutoMultimediale(Integer idEvento, ContenutoMultimediale contenutoMultimediale);
    public void validaEvento(Integer idEvento, boolean validato);
    public void aggiornaListaContenutoMultimediale(Integer idContenutoMultimediale, boolean validato);
    public void aggiornaListaContenutoMultimedialeDaSegnalare(Integer id);
    public void accettaSegnalazioneContenuto(Integer idContenutoMultimediale, boolean eliminato);
    public void apriEvento(Evento evento);
    public void chiudiEvento(Evento evento);
}
