package it.unicam.cs.service;

import it.unicam.cs.model.DTO.RichiestaValidazioneDto;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.repository.IContenutoMultimedialeRepository;
import it.unicam.cs.repository.UtenteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
public class ContenutoMultimedialeService {
    private IContenutoMultimedialeRepository contenutoMultimedialeRepository;
    private UtenteRepository utenteRepository;

    public void validaContenutoMultimediale(Integer idContenutoMultimediale, boolean validato){
        ContenutoMultimediale contenutoMultimediale = contenutoMultimedialeRepository.getReferenceById(idContenutoMultimediale);
        Utente utente = utenteRepository.findByContenutoMultimedialeId(idContenutoMultimediale);
        if(validato){
            contenutoMultimediale.setStato(utente);
            contenutoMultimedialeRepository.save(contenutoMultimediale);
        }
        else {
            contenutoMultimedialeRepository.deleteById(idContenutoMultimediale);
        }
    }
}
