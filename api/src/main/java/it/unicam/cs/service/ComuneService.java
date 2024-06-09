package it.unicam.cs.service;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Contest;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.repository.IComuneRepository;
import it.unicam.cs.repository.UtenteRepository;
import it.unicam.cs.service.Interfaces.IComuneService;
import it.unicam.cs.service.Interfaces.IConsultazioneContenutiService;
import it.unicam.cs.util.enums.RuoliUtente;
import it.unicam.cs.util.enums.StatoElemento;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
public class ComuneService implements IComuneService {
    @Autowired
    private IComuneRepository comuneRepository;
    @Autowired
    IConsultazioneContenutiService consultazioneContenutiService;
    @Autowired
    private UtenteRepository utenteRepository;

    @Override
    @Transactional
    public void aggiungiUtente(Utente utente, Integer idComune) {
        Comune comune = comuneRepository.findById(idComune).orElseThrow(() -> new EntityNotFoundException("comune non trovato"));
        if(utente.getRuoli().stream().map(Ruolo::getNome)
                .collect(Collectors.toList()).contains(RuoliUtente.CURATORE.name())){
            comune.aggiungiCuratore(utente);
        }
        else {
            comune.aggiungiUtente(utente);
        }
    }

    @Override
    @Transactional
    public void aggiungiPOI(Integer idComune, POI poi){
        Comune comune = comuneRepository.findById(idComune).orElseThrow(() -> new EntityNotFoundException("comune non trovato"));
        comune.aggiungiPOI(poi);
        comuneRepository.save(comune);
    }
    @Override
    @Transactional
    public void aggiungiItinerario(Integer idComune, Itinerario itinerario){
        Comune comune = comuneRepository.findById(idComune).orElseThrow(() -> new EntityNotFoundException("comune non trovato"));
        comune.aggiugniItinerario(itinerario);
        comuneRepository.save(comune);
    }
    @Override
    @Transactional
    public void aggiungiEvento(Integer idComune, Evento evento){
        Comune comune = comuneRepository.findById(idComune).orElseThrow(() -> new EntityNotFoundException("comune non trovato"));
        comune.aggiungiEvento(evento);
        comuneRepository.save(comune);
    }
    @Override
    @Transactional
    public void aggiungiContenutoMultimediale(Integer idComune, ContenutoMultimediale contenutoMultimediale){
        Comune comune = comuneRepository.findById(idComune).orElseThrow(() -> new EntityNotFoundException("comune non trovato"));
        comune.aggiungiContenutoMultimediale(contenutoMultimediale);
        comuneRepository.save(comune);
    }
    @Override
    @Transactional
    public void aggiungiContest(Integer idComune, Contest contest){
        Comune comune = comuneRepository.findById(idComune).orElseThrow(() -> new EntityNotFoundException("comune non trovato"));
        comune.aggiungiContest(contest);
        comuneRepository.save(comune);
    }
    @Override
    @Transactional
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
    @Override
    @Transactional
    public void aggiornaListaItinerario(Integer idItinerario, boolean validato){
        Comune comune = comuneRepository.findByItinerarioId(idItinerario);
        Utente utente = utenteRepository.findByIitinerarioId(idItinerario);
        if(validato){
            comune.getItinerari()
                    .stream()
                    .filter(itinerario -> itinerario.getId().equals(idItinerario))
                    .forEach(itinerario -> itinerario.setStato(StatoElemento.PUBBLICATO));
            comuneRepository.save(comune);
        }
        else {
            Itinerario itinerario = consultazioneContenutiService.ottieniItinerarioDaId(idItinerario);
            comune.getItinerari().remove(itinerario);
            comuneRepository.save(comune);
        }
    }
    @Override
    @Transactional
    public void aggiornaListaEvento(Integer idEvento, boolean validato){
        Comune comune = comuneRepository.findByEvento(idEvento);
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
    @Override
    @Transactional
    public void aggiornaListaContenutiMultimediali(Integer idContenuto, boolean validato) {
        Comune comune = comuneRepository.findByContenutoMultimedialeId(idContenuto);
        if(validato){
            comune.getContenutiMultimediali()
                    .stream()
                    .filter(contenutoMultimediale -> contenutoMultimediale.getId().equals(idContenuto))
                    .forEach(contenutoMultimediale -> contenutoMultimediale.setStato(StatoElemento.PUBBLICATO));
            comuneRepository.save(comune);
        }
        else {
            ContenutoMultimediale contenutoMultimediale = consultazioneContenutiService.ottieniContenutoMultimedialeDaId(idContenuto);
            comune.getContenutiMultimediali().remove(contenutoMultimediale);
            comuneRepository.save(comune);
        }
    }
    @Override
    @Transactional
    public void aggiornaListaContenutiMultimedialiSegnalati(Integer id) {
        Comune comune = comuneRepository.findByContenutoMultimedialeId(id);
        comune.getContenutiMultimediali()
                .stream()
                .filter(contenutoMultimediale -> contenutoMultimediale.getId().equals(id))
                .forEach(contenutoMultimediale -> contenutoMultimediale.setStato(StatoElemento.SEGNALATO));
    }
    @Override
    @Transactional
    public void accettaSegnalazioneContenuto(Integer idContenutoMultimediale, boolean eliminato) {
        Comune comune = comuneRepository.findByContenutoMultimedialeId(idContenutoMultimediale);
        ContenutoMultimediale contenutoMultimediale = consultazioneContenutiService.ottieniContenutoMultimedialeDaId(idContenutoMultimediale);
        if(eliminato){
            comune.getContenutiMultimediali().remove(contenutoMultimediale);
            comuneRepository.save(comune);
        }
        else {
            comune.getContenutiMultimediali()
                    .stream()
                    .filter(contenutoMultimediale1 -> contenutoMultimediale1.getId().equals(idContenutoMultimediale))
                    .forEach(contenutoMultimediale1 -> contenutoMultimediale1.setStato(StatoElemento.PUBBLICATO));
            comuneRepository.save(comune);
        }
    }
    @Override
    @Transactional
    public void aggiornaListaEventiDaAprire(Integer idEvento) {
        Comune comune = comuneRepository.findByEvento(idEvento);
        comune.getEventi()
                .stream()
                .filter(evento -> evento.getId().equals(idEvento))
                .forEach(evento -> evento.setAperto(true));
        comuneRepository.save(comune);
    }
    @Override
    @Transactional
    public void aggiornaListaEventiDaChiudere(Integer idEvento) {
        Comune comune = comuneRepository.findByEvento(idEvento);
        Evento evento = consultazioneContenutiService.ottieniEventoDaId(idEvento);
        comune.getEventi().remove(evento);
        comuneRepository.save(comune);
    }
}
