package it.unicam.cs.service;

import it.unicam.cs.Mediators.*;
import it.unicam.cs.model.DTO.RichiestaValidazioneDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class ValidazioneService {
    private POIMediator poiMediator;
    private ItinerarioMediator itinerarioMediator;
    private EventoMediator eventoMediator;
    private ContenutoMultimedialeMediator contenutoMultimedialeMediator;
    private ContenutoContestMediator contenutoContestMediator;

    public void validaPOI(RichiestaValidazioneDto richiestaValidazioneDto){
        poiMediator.validaPOI(richiestaValidazioneDto);
    }
}
