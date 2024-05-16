package it.unicam.cs.service;

import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.repository.IItinerarioRepository;
import it.unicam.cs.repository.UtenteRepository;
import it.unicam.cs.util.enums.StatoElemento;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
public class ItinerarioService {
    private IItinerarioRepository  itinerarioRepository;
    private UtenteRepository utenteRepository;
    private ConsultazioneContenutiService consultazioneContenutiService;

    public void salvaContenutoMultimediale(ContenutoMultimediale contenutoMultimediale, Integer idItinerario){
        Itinerario itinerario = itinerarioRepository.getReferenceById(idItinerario);
        itinerario.aggiungiContenutoMultimediale(contenutoMultimediale);
        itinerarioRepository.save(itinerario);
    }
    public void validaItinerario(Integer idItinerario, boolean validato){
        Itinerario itinerario = itinerarioRepository.getReferenceById(idItinerario);
        if(validato){
            itinerario.setStato(StatoElemento.PUBBLICATO);
            itinerarioRepository.save(itinerario);
        }
        else {
            itinerarioRepository.deleteById(idItinerario);
        }
    }
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

    public void aggiornaListaContenutoMultimedialeDaSegnalare(Integer id) {
        Itinerario itinerario = itinerarioRepository.findItinerarioByContenutoMultimedialeId(id);
        itinerario.getContenutiMultimedialiAssociati()
                .stream()
                .filter(contenutoMultimediale -> contenutoMultimediale.getId().equals(id))
                .forEach(contenutoMultimediale -> contenutoMultimediale.setStato(StatoElemento.SEGNALATO));
        itinerarioRepository.save(itinerario);
    }

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
