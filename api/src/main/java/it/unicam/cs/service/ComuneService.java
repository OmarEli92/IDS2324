package it.unicam.cs.service;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.repository.IComuneRepository;
import it.unicam.cs.repository.UtenteRepository;
import it.unicam.cs.util.enums.StatoElemento;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
public class ComuneService {
    @Autowired
    private IComuneRepository comuneRepository;
    @Autowired
    ConsultazioneContenutiService consultazioneContenutiService;
    @Autowired
    private  UtenteRepository utenteRepository;

    public void aggiungiPOI(Integer idComune, POI poi){
        Comune comune = comuneRepository.getReferenceById(idComune);
        comune.aggiungiPOI(poi);
        comuneRepository.save(comune);
    }
    public void aggiungiItinerario(Integer idComune, Itinerario itinerario){
        Comune comune = comuneRepository.getReferenceById(idComune);
        comune.aggiugniItinerario(itinerario);
        comuneRepository.save(comune);
    }
    public void aggiungiEvento(Integer idComune, Evento evento){
        Comune comune = comuneRepository.getReferenceById(idComune);
        comune.aggiungiEvento(evento);
        comuneRepository.save(comune);
    }
    public void aggiungiContenutoMultimediale(Integer idComune, ContenutoMultimediale contenutoMultimediale){
        Comune comune = comuneRepository.getReferenceById(idComune);
        comune.aggiungiContenutoMultimediale(contenutoMultimediale);
        comuneRepository.save(comune);
    }
    public void aggiornaListaPOI(Integer idPOI, boolean validato){
        Comune comune = comuneRepository.findByPOIId(idPOI);
        if(validato){
            comune.getPOIS()
                    .stream()
                    .filter(poi -> poi.getId().equals(idPOI))
                    .forEach(poi -> poi.setStato(StatoElemento.PUBBLICATO));
            comuneRepository.save(comune);
        }
        else {
            POI poi = consultazioneContenutiService.ottieniPOIdaId(idPOI);
            comune.getPOIS().remove(poi);
            comuneRepository.save(comune);
        }
    }
    public void aggiornaListaItinerario(Integer idItinerario, boolean validato){
        Comune comune = comuneRepository.findByItinerarioId(idItinerario);
        Utente utente = utenteRepository.findByIitinerarioId(idItinerario);
        if(validato){
            comune.getItinerari()
                    .stream()
                    .filter(itinerario -> itinerario.getId().equals(idItinerario))
                    .forEach(itinerario -> itinerario.setStato(utente));
            comuneRepository.save(comune);
        }
        else {
            Itinerario itinerario = consultazioneContenutiService.ottieniItinerarioDaId(idItinerario);
            comune.getItinerari().remove(itinerario);
            comuneRepository.save(comune);
        }
    }
    public void aggiornaListaEvento(Integer idEvento, boolean validato){
        Comune comune = comuneRepository.findByEvento(idEvento);
        Utente utente = utenteRepository.findByEventoId(idEvento);
        if(validato){
            comune.getEventi()
                    .stream()
                    .filter(evento -> evento.getId().equals(idEvento))
                    .forEach(evento -> evento.setStato(StatoElemento.PUBBLICATO));
            comuneRepository.save(comune);
        }
        else {
            Evento evento = consultazioneContenutiService.ottieniEventoDaId(idEvento);
            comune.getEventi().remove(evento);
            comuneRepository.save(comune);
        }
    }
}
