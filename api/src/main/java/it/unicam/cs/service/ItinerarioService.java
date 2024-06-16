package it.unicam.cs.service;

import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.repository.IItinerarioRepository;
import it.unicam.cs.repository.UtenteRepository;
import it.unicam.cs.service.Interfaces.IConsultazioneContenutiService;
import it.unicam.cs.service.Interfaces.IItinerarioService;
import it.unicam.cs.util.VerificaSomiglianzaContenuti;
import it.unicam.cs.util.enums.StatoElemento;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
public class ItinerarioService implements IItinerarioService {
    private IItinerarioRepository  itinerarioRepository;
    private UtenteRepository utenteRepository;
    private IConsultazioneContenutiService consultazioneContenutiService;
    private VerificaSomiglianzaContenuti verificaSomiglianzaContenuti;
    @Override
    public void aggiungiItinerario(Itinerario itinerario){
        if(!verificaSomiglianzaContenuti.verificaSomiglianzaItinerario(itinerario,itinerarioRepository.findAll())){
            itinerarioRepository.save(itinerario);
        }
        else{
            throw new IllegalArgumentException("itinerario già esistente");
        }
    }
    @Override
    @Transactional
    public void salvaContenutoMultimediale(ContenutoMultimediale contenutoMultimediale, Integer idItinerario){
        Itinerario itinerario = consultazioneContenutiService.ottieniItinerarioDaId(idItinerario);
        itinerario.aggiungiContenutoMultimediale(contenutoMultimediale);
        itinerarioRepository.save(itinerario);
    }
    @Override
    public void validaItinerario(Integer idItinerario, boolean validato){
        Itinerario itinerario = consultazioneContenutiService.ottieniItinerarioDaId(idItinerario);
        if(validato){
            itinerario.setStato(StatoElemento.PUBBLICATO);
            itinerarioRepository.save(itinerario);
        }
        else {
            itinerarioRepository.deleteById(idItinerario);
        }
    }
    @Override
    @Transactional
    public void aggiornaListaContenutoMultimediale(Integer idContenutoMultimediale, boolean validato){
        Itinerario itinerario = itinerarioRepository.findItinerarioByContenutoMultimedialeId(idContenutoMultimediale);
        Utente utente = utenteRepository.findByContenutoMultimedialeId(idContenutoMultimediale);
        if(validato){
            itinerario.getContenutiMultimedialiAssociati()
                    .stream()
                    .filter(contenutoMultimediale -> contenutoMultimediale.getId().equals(idContenutoMultimediale))
                    .forEach(contenutoMultimediale -> contenutoMultimediale.setStato(StatoElemento.PUBBLICATO));
            itinerarioRepository.save(itinerario);
        }
        else {
            ContenutoMultimediale contenutoMultimediale = consultazioneContenutiService.ottieniContenutoMultimedialeDaId(idContenutoMultimediale);
            itinerario.getContenutiMultimedialiAssociati().remove(contenutoMultimediale);
            itinerarioRepository.save(itinerario);
        }
    }
    @Override
    @Transactional
    public void aggiornaListaContenutoMultimedialeDaSegnalare(Integer id) {
        Itinerario itinerario = itinerarioRepository.findItinerarioByContenutoMultimedialeId(id);
        itinerario.getContenutiMultimedialiAssociati()
                .stream()
                .filter(contenutoMultimediale -> contenutoMultimediale.getId().equals(id))
                .forEach(contenutoMultimediale -> contenutoMultimediale.setStato(StatoElemento.SEGNALATO));
        itinerarioRepository.save(itinerario);
    }
    @Override
    @Transactional
    public void accettaSegnalazioneContenuto(Integer idContenutoMultimediale, boolean eliminato) {
        Itinerario itinerario = itinerarioRepository.findItinerarioByContenutoMultimedialeId(idContenutoMultimediale);
        ContenutoMultimediale contenutoMultimediale = consultazioneContenutiService.ottieniContenutoMultimedialeDaId(idContenutoMultimediale);
        if (eliminato){
            itinerario.getContenutiMultimedialiAssociati().remove(contenutoMultimediale);
            itinerarioRepository.save(itinerario);
        }
        else {
            itinerario.getContenutiMultimedialiAssociati()
                    .stream()
                    .filter(contenutoMultimediale1 -> contenutoMultimediale1.getId().equals(idContenutoMultimediale))
                    .forEach(contenutoMultimediale1 -> contenutoMultimediale1.setStato(StatoElemento.PUBBLICATO));
            itinerarioRepository.save(itinerario);
        }
    }
}
