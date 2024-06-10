package it.unicam.cs.service.Interfaces;

import it.unicam.cs.model.contenuti.ContenutoMultimediale;

public interface IContenutoMultimedialeService {
    public void aggiungiContenutoMultimediale(ContenutoMultimediale contenutoMultimediale);
    public void validaContenutoMultimediale(Integer idContenutoMultimediale, boolean validato);
    public void segnalaContenuto(ContenutoMultimediale contenutoMultimediale);
    public void accettaSegnalazioneContenuto(ContenutoMultimediale contenutoMultimediale, boolean eliminato);
}
