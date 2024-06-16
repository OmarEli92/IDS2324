package it.unicam.cs.service;

import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.repository.IContenutoMultimedialeRepository;
import it.unicam.cs.repository.UtenteRepository;
import it.unicam.cs.service.Interfaces.IContenutoMultimedialeService;
import it.unicam.cs.util.VerificaSomiglianzaContenuti;
import it.unicam.cs.util.enums.StatoElemento;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
public class ContenutoMultimedialeService implements IContenutoMultimedialeService {
    private IContenutoMultimedialeRepository contenutoMultimedialeRepository;
    private VerificaSomiglianzaContenuti verificaSomiglianzaContenuti;
    private ConsultazioneContenutiService consultazioneContenutiService;
    @Override
    public void aggiungiContenutoMultimediale(ContenutoMultimediale contenutoMultimediale){
        if(!verificaSomiglianzaContenuti.verificaSomiglianzaContenutoMultimediale(contenutoMultimediale, contenutoMultimedialeRepository.findAll())){
            contenutoMultimedialeRepository.save(contenutoMultimediale);
        }
        else{
            throw new IllegalArgumentException("contenuto multimediale già esistente");
        }
    }
    @Override
    public void validaContenutoMultimediale(Integer idContenutoMultimediale, boolean validato){
        ContenutoMultimediale contenutoMultimediale = consultazioneContenutiService.ottieniContenutoMultimedialeDaId(idContenutoMultimediale);
        if(validato){
            contenutoMultimediale.setStato(StatoElemento.PUBBLICATO);
            contenutoMultimedialeRepository.save(contenutoMultimediale);
        }
        else {
            contenutoMultimedialeRepository.deleteById(idContenutoMultimediale);
        }
    }
    @Override
    public void segnalaContenuto(ContenutoMultimediale contenutoMultimediale) {
        contenutoMultimediale.setStato(StatoElemento.SEGNALATO);
        contenutoMultimedialeRepository.save(contenutoMultimediale);
    }
    @Override
    public void accettaSegnalazioneContenuto(ContenutoMultimediale contenutoMultimediale, boolean eliminato) {
        if(eliminato){
            contenutoMultimedialeRepository.delete(contenutoMultimediale);
        }
        else {
            contenutoMultimediale.setStato(StatoElemento.PUBBLICATO);
            contenutoMultimedialeRepository.save(contenutoMultimediale);
        }
    }
}
