package it.unicam.cs.service.Interfaces;

import it.unicam.cs.model.DTO.input.RichiestaValidazioneDto;

public interface IValidazioneContenutiService {
    public void validaPOI(RichiestaValidazioneDto richiestaValidazioneDto);
    public void validaItinerario(RichiestaValidazioneDto richiestaValidazioneDto);
    public void validaEvento(RichiestaValidazioneDto richiestaValidazioneDto);
    public void validaContenutoMultimediale(RichiestaValidazioneDto richiestaValidazioneDto);
    public void validaContenutoContest(RichiestaValidazioneDto richiestaValidazioneDto);
}
