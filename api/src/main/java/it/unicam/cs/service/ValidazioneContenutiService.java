package it.unicam.cs.service;

import it.unicam.cs.Mediators.*;
import it.unicam.cs.model.DTO.input.RichiestaValidazioneDto;
import it.unicam.cs.service.Interfaces.IValidazioneContenutiService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class ValidazioneContenutiService implements IValidazioneContenutiService {
    private POIMediator poiMediator;
    private ItinerarioMediator itinerarioMediator;
    private EventoMediator eventoMediator;
    private ContenutoMultimedialeMediator contenutoMultimedialeMediator;
    private ContenutoContestMediator contenutoContestMediator;
    @Override
    public void validaPOI(RichiestaValidazioneDto richiestaValidazioneDto){
        poiMediator.validaPOI(richiestaValidazioneDto);
    }
    @Override
    public void validaItinerario(RichiestaValidazioneDto richiestaValidazioneDto){
        itinerarioMediator.validaItinerario(richiestaValidazioneDto);
    }
    @Override
    public void validaEvento(RichiestaValidazioneDto richiestaValidazioneDto){
        eventoMediator.validaEvento(richiestaValidazioneDto);
    }
    @Override
    public void validaContenutoMultimediale(RichiestaValidazioneDto richiestaValidazioneDto){
        contenutoMultimedialeMediator.validaContenuto(richiestaValidazioneDto);
    }
    @Override
    public void validaContenutoContest(RichiestaValidazioneDto richiestaValidazioneDto){
        contenutoContestMediator.validaContenutoContest(richiestaValidazioneDto);
    }
}
