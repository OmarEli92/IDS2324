package it.unicam.cs.service;

import it.unicam.cs.model.Contest;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.ContenutoContest;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.repository.IEventoRepository;
import it.unicam.cs.repository.IPOIRepository;
import it.unicam.cs.repository.UtenteRepository;
import it.unicam.cs.service.Interfaces.IConsultazioneContenutiService;
import it.unicam.cs.service.Interfaces.IPOIService;
import it.unicam.cs.util.VerificaSomiglianzaContenuti;
import it.unicam.cs.util.enums.StatoElemento;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class POIService implements IPOIService {
    private IPOIRepository poiRepository;
    private IConsultazioneContenutiService consultazioneContenutiService;
    private VerificaSomiglianzaContenuti verificaSomiglianzaContenuti;
    @Override
    public void aggiungiPOI(POI poi){
        if(!verificaSomiglianzaContenuti.verificaSomiglianzaPOI(poi, poiRepository.findAll())){
            poiRepository.save(poi);
        }
        else {
            throw new IllegalArgumentException("poi già esistente");
        }
    }
    @Override
    @Transactional
    public void salvaContenutoMultimediale(Integer idPoi, ContenutoMultimediale contenutoMultimediale){
        POI poi = poiRepository.findById(idPoi).orElseThrow(()->new EntityNotFoundException("poi non trovato"));
        poi.aggiungiContenutoMultimediale(contenutoMultimediale);
        poiRepository.save(poi);
    }
    @Override
    @Transactional
    public void salvaEvento(Integer idPoi, Evento evento){
        POI poi = poiRepository.findById(idPoi).orElseThrow(()->new EntityNotFoundException("poi non trovato"));
        poi.aggiungiEvento(evento);
        poiRepository.save(poi);
    }
    @Override
    @Transactional
    public void salvaContest(Integer idPoi, Contest contest){
        POI poi = poiRepository.findById(idPoi).orElseThrow(()->new EntityNotFoundException("poi non trovato"));
        poi.aggiungiContest(contest);
        poiRepository.save(poi);
    }
    @Override
    public void validaPOI(Integer id, boolean validato){
        POI poi = consultazioneContenutiService.ottieniPOIdaId(id);
        if (validato){
            poi.setStato(StatoElemento.PUBBLICATO);
            poiRepository.save(poi);
        }
        else {
            poiRepository.deleteById(id);
        }
    }
    @Override
    @Transactional
    public void aggiornaListaEvento(Integer idEvento, boolean validato){
        POI poi = poiRepository.findPOIByIdEvento(idEvento);
        if(validato){
            poi.getEventiAssociati()
                    .stream()
                    .filter(evento -> evento.getId().equals(idEvento))
                    .forEach(evento -> evento.setStato(StatoElemento.PUBBLICATO));
            poiRepository.save(poi);
        }
        else{
            Evento evento = consultazioneContenutiService.ottieniEventoDaId(idEvento);
            poi.getEventiAssociati().remove(evento);
            poiRepository.save(poi);
        }
    }
    @Override
    @Transactional
    public void aggiornaListaContenutoMultimediale(Integer idContenutoMultimediale, boolean validato){
        POI poi = poiRepository.findByIdContenutoMultimediale(idContenutoMultimediale);
        if(validato){
            poi.getContenutiMultimediali()
                    .stream()
                    .filter(contenutoMultimediale -> contenutoMultimediale.getId().equals(idContenutoMultimediale))
                    .forEach(contenutoMultimediale -> contenutoMultimediale.setStato(StatoElemento.PUBBLICATO));
            poiRepository.save(poi);
        }
        else {
            ContenutoMultimediale contenutoMultimediale = consultazioneContenutiService.ottieniContenutoMultimedialeDaId(idContenutoMultimediale);
            poi.getContenutiMultimediali().remove(contenutoMultimediale);
            poiRepository.save(poi);
        }
    }
    @Override
    @Transactional
    public void aggiornaListaContenutoMultimedialeDaSegnalare(Integer id) {
        POI poi = poiRepository.findByIdContenutoMultimediale(id);
        poi.getContenutiMultimediali()
                .stream()
                .filter(contenutoMultimediale -> contenutoMultimediale.getId().equals(id))
                .forEach(contenutoMultimediale -> contenutoMultimediale.setStato(StatoElemento.SEGNALATO));
        poiRepository.save(poi);
    }
    @Override
    @Transactional
    public void accettaSegnalazioneContenuto(Integer idContenutoMultimediale, boolean eliminato) {
        POI poi = poiRepository.findByIdContenutoMultimediale(idContenutoMultimediale);
        ContenutoMultimediale contenutoMultimediale = consultazioneContenutiService.ottieniContenutoMultimedialeDaId(idContenutoMultimediale);
        if(eliminato){
            poi.getContenutiMultimediali().remove(contenutoMultimediale);
            poiRepository.save(poi);
        }
        else {
            poi.getContenutiMultimediali()
                    .stream()
                    .filter(contenutoMultimediale1 -> contenutoMultimediale1.getId().equals(idContenutoMultimediale))
                    .forEach(contenutoMultimediale1 -> contenutoMultimediale1.setStato(StatoElemento.PUBBLICATO));
            poiRepository.save(poi);
        }
    }
    @Override
    @Transactional
    public void aggiornaListaContestDaChiudere(Integer idContest) {
        POI poi = poiRepository.findByIdContest(idContest);
        poi.getContestAssociati()
                .stream()
                .filter(contest -> contest.getId().equals(idContest))
                .forEach(contest -> contest.setAttivo(false));
    }
    @Override
    @Transactional
    public void aggiornaListaContestAperti(Integer idContest) {
        POI poi = poiRepository.findByIdContest(idContest);
        poi.getContestAssociati()
                .stream()
                .filter(contest1 -> contest1.getId().equals(idContest))
                .forEach(contest1 -> contest1.setAttivo(true));
    }
    @Override
    @Transactional
    public void aggiornaListaEventiDaAprire(Integer idEvento) {
        POI poi = poiRepository.findPOIByIdEvento(idEvento);
        poi.getEventiAssociati()
                .stream()
                .filter(evento -> evento.getId().equals(idEvento))
                .forEach(evento -> evento.setAperto(true));
        poiRepository.save(poi);
    }
    @Override
    @Transactional
    public void aggiornaListaEventiDaChiudere(Integer idEvento) {
        POI poi = poiRepository.findPOIByIdEvento(idEvento);
        Evento evento = consultazioneContenutiService.ottieniEventoDaId(idEvento);
        poi.getEventiAssociati().remove(evento);
        poiRepository.save(poi);
    }
}
