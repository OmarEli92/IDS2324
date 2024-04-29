package it.unicam.cs.service;

import it.unicam.cs.Mediators.*;
import it.unicam.cs.model.DTO.RichiestaValidazioneDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class ValidazioneContenutiService {
    private POIMediator poiMediator;
    private ItinerarioMediator itinerarioMediator;
    private EventoMediator eventoMediator;
    private ContenutoMultimedialeMediator contenutoMultimedialeMediator;
    private ContenutoContestMediator contenutoContestMediator;

    public void validaPOI(RichiestaValidazioneDto richiestaValidazioneDto){
        poiMediator.validaPOI(richiestaValidazioneDto);
    }
    public void validaItinerario(RichiestaValidazioneDto richiestaValidazioneDto){
        itinerarioMediator.validaItinerario(richiestaValidazioneDto);
    }
    public void validaEvento(RichiestaValidazioneDto richiestaValidazioneDto){
        eventoMediator.validaEvento(richiestaValidazioneDto);
    }
}
