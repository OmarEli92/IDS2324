package it.unicam.cs.service.Interfaces;

import it.unicam.cs.model.DTO.input.RichiestaValidazioneDto;

public interface IValidazioneContenutiService {
    public void validaPOI(RichiestaValidazioneDto richiestaValidazioneDto, Integer validatoreId);
    public void validaItinerario(RichiestaValidazioneDto richiestaValidazioneDto, Integer validatoreId);
    public void validaEvento(RichiestaValidazioneDto richiestaValidazioneDto, Integer id);
    public void validaContenutoMultimediale(RichiestaValidazioneDto richiestaValidazioneDto, Integer validatoreId);
    public void validaContenutoContest(RichiestaValidazioneDto richiestaValidazioneDto, Integer id);
}
