package it.unicam.cs.service.CaricamentoService;

import it.unicam.cs.Mediators.ContenutoMultimedialeMediator;
import it.unicam.cs.exception.Contenuto.EventoNotValidException;
import it.unicam.cs.exception.Contenuto.POINotValidException;
import it.unicam.cs.exception.UtenteNotValidException;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.DTO.input.ContenutoMultimedialeDto;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.service.CaricamentoService.Interfaces.ICaricamentoContenutoMultimedialeService;
import it.unicam.cs.service.ConsultazioneContenutiService;
import it.unicam.cs.service.ControlloService.ControlloContenutoMultimedialeService;
import it.unicam.cs.service.Interfaces.IConsultazioneContenutiService;
import it.unicam.cs.service.Interfaces.IUtenteService;
import it.unicam.cs.service.UtenteService;
import it.unicam.cs.util.enums.RuoliUtente;
import it.unicam.cs.util.enums.StatoElemento;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CaricamentoContenutoMultimedialeService implements ICaricamentoContenutoMultimedialeService {
    @Autowired
    private ControlloContenutoMultimedialeService controlloContenutoMultimedialeService;
    @Autowired
    private IUtenteService utenteService;
    @Autowired
    private IConsultazioneContenutiService consultazioneContenutiService;
    @Autowired
    private ContenutoMultimedialeMediator contenutoMultimedialeMediator;
    private POI poi;
    private Itinerario itinerario;
    private Evento evento;
    private Comune comune;
    @Override
    public void caricaContenutoMultimediale(ContenutoMultimedialeDto contenutoMultimedialeDto){
        controlloContenutoMultimedialeService.verificaContenutoMultimediale(contenutoMultimedialeDto);
        ContenutoMultimediale contenutoMultimediale = costruisciContenutoMultimediale(contenutoMultimedialeDto);
        contenutoMultimedialeMediator.salvaContenutoMultimediale(contenutoMultimediale);
    }

    private ContenutoMultimediale costruisciContenutoMultimediale(ContenutoMultimedialeDto contenutoMultimedialeDto) {
        String nome = contenutoMultimedialeDto.getNome();
        Utente utente = utenteService.ottieniUtenteById(contenutoMultimedialeDto.getIdContributore());
        verificaElementoComuneAssociato(contenutoMultimedialeDto.getIdPoi(), contenutoMultimedialeDto.getIdEvento(), contenutoMultimedialeDto.getIdItinerario(),utente);
        StatoElemento statoElemento = isContributoreValid(utente);
        if(this.poi!=null){
            return new ContenutoMultimediale(nome,utente,statoElemento,poi,comune);
        }
        else if(this.evento!=null){
            return new ContenutoMultimediale(nome,utente,statoElemento,evento,comune);
        }
        else {
            return new ContenutoMultimediale(nome,utente,statoElemento,itinerario,comune);
        }
    }
    private void verificaElementoComuneAssociato(Integer idPoi, Integer idEvento, Integer idItinerario, Utente utente) {
        if(idPoi != null){
            this.poi = consultazioneContenutiService.ottieniPOIdaId(idPoi);
        }
        if(idEvento != null){
            this.evento = consultazioneContenutiService.ottieniEventoDaId(idEvento);
        }
        if(idItinerario != null){
            this.itinerario = consultazioneContenutiService.ottieniItinerarioDaId(idItinerario);
        }
        if (poi == null && evento == null && itinerario == null) {
            throw new IllegalArgumentException("l'elemento del comune deve essere settato");
        } else if ((poi != null && evento != null && itinerario != null) ||
                (poi != null && evento != null) || (evento != null && itinerario != null) ||
                (poi != null && itinerario != null)) {
            throw new IllegalArgumentException("ci deve essere un solo elemento del comune settato");
        }
        if(poi != null){
            verificaPoi(poi, utente);
        }
        else if(itinerario != null){
            verificaItinerario(itinerario, utente);
        }
        else {
            verificaEvento(evento, utente);
        }
    }
    private void verificaEvento(Evento evento, Utente utente) {
            if (!evento.getStato().equals(StatoElemento.PUBBLICATO)
                    || !evento.isAperto()){
                throw new IllegalStateException("l'evento non è pubblicato o è chiuso, impossibile aggiungere un contenuto multimediale associato");
            }
            Comune comuneUtente = utente.getComuneAssociato();
            if(!comuneUtente.getEventi().stream()
                    .filter(evento1 -> evento1.getStato().equals(StatoElemento.PUBBLICATO) && evento.isAperto())
                    .collect(Collectors.toList()).contains(evento)){
                throw new EventoNotValidException();
                }
            this.comune = comuneUtente;
    }

    private void verificaPoi(POI poi, Utente utente) {
            if(!poi.getStato().equals(StatoElemento.PUBBLICATO)){
                throw new IllegalStateException("il poi non è pubblicato, impossibile aggiungere un contenuto multimediale associato");
            }
            Comune comuneUtente = utente.getComuneAssociato();
            if (!comuneUtente.getPOIS().stream()
                    .filter(poi1 -> poi1.getStato().equals(StatoElemento.PUBBLICATO))
                    .collect(Collectors.toList()).contains(poi)) {
                throw new POINotValidException();
            }
            this.comune = comuneUtente;

    }
    @Transactional
    private void verificaItinerario(Itinerario itinerario, Utente utente) {
            if(!itinerario.getStato().equals(StatoElemento.PUBBLICATO)){
                throw new IllegalStateException("l'itinerario nonn è pubblicato, impossibile aggiungere un contenuto multimediale associato");
            }
            Comune comuneUtente = utente.getComuneAssociato();
            if(!comuneUtente.getItinerari().stream()
                    .filter(itinerario1->itinerario1.getStato().equals(StatoElemento.PUBBLICATO))
                    .collect(Collectors.toList()).contains(itinerario)){
                throw new IllegalArgumentException("comune dell'itinerario diverso dal comune " +
                        "dell'utente");
            }
            this.comune = comuneUtente;

    }
    private StatoElemento isContributoreValid(Utente utente) {
        StatoElemento stato;
        List<String> nomi = utente.getRuoli()
                .stream()
                .map(Ruolo::getNome)
                .collect(Collectors.toList());
        if(nomi.contains(RuoliUtente.CURATORE.name()) || nomi.contains(RuoliUtente.CONTRIBUTORE_AUTORIZZATO.name())){
            stato = StatoElemento.PUBBLICATO;
        }
        else{
            stato = StatoElemento.PENDING;
        }
        return stato;
    }
}
