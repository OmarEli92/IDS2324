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
    public void validaPOI(RichiestaValidazioneDto richiestaValidazioneDto, Integer validatoreId){
        poiMediator.validaPOI(richiestaValidazioneDto, validatoreId);
    }
    @Override
    public void validaItinerario(RichiestaValidazioneDto richiestaValidazioneDto, Integer validatoreId){
        itinerarioMediator.validaItinerario(richiestaValidazioneDto, validatoreId);
    }
    @Override
    public void validaEvento(RichiestaValidazioneDto richiestaValidazioneDto, Integer id){
        eventoMediator.validaEvento(richiestaValidazioneDto, id);
    }
    @Override
    public void validaContenutoMultimediale(RichiestaValidazioneDto richiestaValidazioneDto, Integer validatoreId){
        contenutoMultimedialeMediator.validaContenuto(richiestaValidazioneDto, validatoreId);
    }
    @Override
    public void validaContenutoContest(RichiestaValidazioneDto richiestaValidazioneDto, Integer validatoreId){
        contenutoContestMediator.validaContenutoContest(richiestaValidazioneDto, validatoreId);
    }
}
