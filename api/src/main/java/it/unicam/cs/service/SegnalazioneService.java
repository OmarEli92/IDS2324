package it.unicam.cs.service;

import it.unicam.cs.Mediators.ContenutoMultimedialeMediator;
import it.unicam.cs.model.DTO.input.RichiestaSegnalazioneDto;
import it.unicam.cs.service.Interfaces.ISegnalazioneService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class SegnalazioneService implements ISegnalazioneService {
    private ContenutoMultimedialeMediator contenutoMultimedialeMediator;
    @Override
    public void segnalaContenutoMultimediale(RichiestaSegnalazioneDto richiestaSegnalazioneDto){
        contenutoMultimedialeMediator.segnalaContenutoMultimediale(richiestaSegnalazioneDto);
    }
}
