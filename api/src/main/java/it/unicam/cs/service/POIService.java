package it.unicam.cs.service;

import it.unicam.cs.model.Contest;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.ContenutoContest;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.repository.IContestRepository;
import it.unicam.cs.repository.IEventoRepository;
import it.unicam.cs.repository.IPOIRepository;
import it.unicam.cs.repository.UtenteRepository;
import it.unicam.cs.util.enums.StatoElemento;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class POIService {
    private IPOIRepository poiRepository;
    private UtenteRepository utenteRepository;
    private IEventoRepository eventoRepository;
    private ConsultazioneContenutiService consultazioneContenutiService;
    public void salvaContenutoMultimediale(Integer idPoi, ContenutoMultimediale contenutoMultimediale){
        POI poi = poiRepository.getReferenceById(idPoi);
        poi.aggiungiContenutoMultimediale(contenutoMultimediale);
        poiRepository.save(poi);
    }
    public void salvaEvento(Integer idPoi, Evento evento){
        POI poi = poiRepository.getReferenceById(idPoi);
        poi.aggiungiEvento(evento);
        poiRepository.save(poi);
    }
    public void salvaContest(Integer idPoi, Contest contest){
        POI poi = poiRepository.getReferenceById(idPoi);
        poi.aggiungiContest(contest);
        poiRepository.save(poi);
    }
    public void salvaContenutoContest(Integer idPoi, ContenutoContest contenutoContest){
        POI poi = poiRepository.getReferenceById(idPoi);

    }
    public void validaPOI(Integer id, boolean validato){
        POI poi = poiRepository.getReferenceById(id);
        if (validato){
            poi.setStato(StatoElemento.PUBBLICATO);
            poiRepository.save(poi);
        }
        else {
            poiRepository.deleteById(id);
        }
    }
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
    public void aggiornaListaContenutoMultimediale(Integer idContenutoMultimediale, boolean validato){
        POI poi = poiRepository.findByIdContenutoMultimediale(idContenutoMultimediale);
        Utente utente = utenteRepository.findByContenutoMultimedialeId(idContenutoMultimediale);
        if(validato){
            poi.getContenutiMultimediali()
                    .stream()
                    .filter(contenutoMultimediale -> contenutoMultimediale.getId().equals(idContenutoMultimediale))
                    .forEach(contenutoMultimediale -> contenutoMultimediale.setStato(utente));
            poiRepository.save(poi);
        }
        else {
            ContenutoMultimediale contenutoMultimediale = consultazioneContenutiService.ottieniContenutoMultimedialeDaId(idContenutoMultimediale);
            poi.getContenutiMultimediali().remove(contenutoMultimediale);
            poiRepository.save(poi);
        }
    }
}
