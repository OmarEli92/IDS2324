package it.unicam.cs.service;

import it.unicam.cs.Mediators.ContenutoMultimedialeMediator;
import it.unicam.cs.model.DTO.input.EliminazioneContenutoDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class EliminazioneContenutiService {
    private ContenutoMultimedialeMediator contenutoMultimedialeMediator;

    public void accettaSegnalazioneContenuto(EliminazioneContenutoDto eliminazioneContenutoDto){
        contenutoMultimedialeMediator.accettaSegnalazioneContenuto(eliminazioneContenutoDto);
    }
}
