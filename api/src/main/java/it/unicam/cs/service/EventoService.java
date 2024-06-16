package it.unicam.cs.service;

import it.unicam.cs.Mediators.EventoMediator;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.repository.IEventoRepository;
import it.unicam.cs.repository.UtenteRepository;
import it.unicam.cs.service.Interfaces.IConsultazioneContenutiService;
import it.unicam.cs.service.Interfaces.IEventoService;
import it.unicam.cs.util.VerificaSomiglianzaContenuti;
import it.unicam.cs.util.enums.StatoElemento;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class EventoService implements IEventoService {
    private IEventoRepository eventoRepository;
    private IConsultazioneContenutiService consultazioneContenutiService;
    private VerificaSomiglianzaContenuti verificaSomiglianzaContenuti;
   @Override
    public void aggiungiEvento(Evento evento){
        if(!verificaSomiglianzaContenuti.verificaSomiglianzaEvento(evento,eventoRepository.findAll())){
            eventoRepository.save(evento);
        }
        else {
            throw new IllegalArgumentException("evento già esistente");
        }
    }
    @Override
    @Transactional
    public void salvaContenutoMultimediale(Integer idEvento, ContenutoMultimediale contenutoMultimediale){
        Evento evento = consultazioneContenutiService.ottieniEventoDaId(idEvento);
        evento.aggiungiContenutoMultimediale(contenutoMultimediale);
        eventoRepository.save(evento);
    }
    @Override
    public void validaEvento(Integer idEvento, boolean validato){
        Evento evento = consultazioneContenutiService.ottieniEventoDaId(idEvento);
        if(validato){
            evento.setStato(StatoElemento.PUBBLICATO);
            eventoRepository.save(evento);
        }
        else {
            eventoRepository.deleteById(idEvento);
        }
    }
    @Override
    @Transactional
    public void aggiornaListaContenutoMultimediale(Integer idContenutoMultimediale, boolean validato){
        Evento evento = eventoRepository.findEventoByContenutoMultimedialeId(idContenutoMultimediale);
        if(validato){
            evento.getContenutiMultimediali()
                    .stream()
                    .filter(contenutoMultimediale -> contenutoMultimediale.getId().equals(idContenutoMultimediale))
                    .forEach(contenutoMultimediale -> contenutoMultimediale.setStato(StatoElemento.PUBBLICATO));
            eventoRepository.save(evento);
        }
        else {
            ContenutoMultimediale contenutoMultimediale = consultazioneContenutiService.ottieniContenutoMultimedialeDaId(idContenutoMultimediale);
            evento.getContenutiMultimediali().remove(contenutoMultimediale);
            eventoRepository.save(evento);
        }
    }
    @Override
    @Transactional
    public void aggiornaListaContenutoMultimedialeDaSegnalare(Integer id) {
        Evento evento = eventoRepository.findEventoByContenutoMultimedialeId(id);
        evento.getContenutiMultimediali()
                .stream()
                .filter(contenutoMultimediale -> contenutoMultimediale.getId().equals(id))
                .forEach(contenutoMultimediale -> contenutoMultimediale.setStato(StatoElemento.SEGNALATO));
        eventoRepository.save(evento);
    }
    @Override
    @Transactional
    public void accettaSegnalazioneContenuto(Integer idContenutoMultimediale, boolean eliminato) {
        Evento evento = eventoRepository.findEventoByContenutoMultimedialeId(idContenutoMultimediale);
        ContenutoMultimediale contenutoMultimediale = consultazioneContenutiService.ottieniContenutoMultimedialeDaId(idContenutoMultimediale);
        if(eliminato){
            evento.getContenutiMultimediali().remove(contenutoMultimediale);
            eventoRepository.save(evento);
        }
        else {
            evento.getContenutiMultimediali()
                    .stream()
                    .filter(contenutoMultimediale1 -> contenutoMultimediale1.getId().equals(idContenutoMultimediale))
                    .forEach(contenutoMultimediale1 -> contenutoMultimediale1.setStato(StatoElemento.PUBBLICATO));
            eventoRepository.save(evento);
        }
    }
    @Override
    public void apriEvento(Evento evento){
        evento.setAperto(true);
        eventoRepository.save(evento);
    }
    @Override
    public void chiudiEvento(Evento evento){
        eventoRepository.delete(evento);
    }
}
