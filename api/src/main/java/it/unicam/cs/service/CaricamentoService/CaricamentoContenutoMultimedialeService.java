package it.unicam.cs.service.CaricamentoService;

import it.unicam.cs.Mediators.ContenutoMultimedialeMediator;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.DTO.ContenutoMultimedialeDto;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.repository.IEventoRepository;
import it.unicam.cs.repository.IItinerarioRepository;
import it.unicam.cs.repository.IPOIRepository;
import it.unicam.cs.repository.UtenteRepository;
import it.unicam.cs.service.ConsultazioneContenutiService;
import it.unicam.cs.service.ControlloService.ControlloContenutoMultimedialeService;
import it.unicam.cs.service.POIService;
import it.unicam.cs.service.UtenteService;
import it.unicam.cs.util.enums.RuoliUtente;
import it.unicam.cs.util.enums.StatoElemento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CaricamentoContenutoMultimedialeService {
    @Autowired
    private ControlloContenutoMultimedialeService controlloContenutoMultimedialeService;
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private ConsultazioneContenutiService consultazioneContenutiService;
    @Autowired
    private ContenutoMultimedialeMediator contenutoMultimedialeMediator;

    public void caricaContenutoMultimediale(ContenutoMultimedialeDto contenutoMultimedialeDto){
        controlloContenutoMultimedialeService.verificaContenutoMultimediale(contenutoMultimedialeDto);
        ContenutoMultimediale contenutoMultimediale = costruisciContenutoMultimediale(contenutoMultimedialeDto);
        contenutoMultimedialeMediator.salvaContenutoMultimediale(contenutoMultimediale);
    }

    private ContenutoMultimediale costruisciContenutoMultimediale(ContenutoMultimedialeDto contenutoMultimedialeDto) {
        String nome = contenutoMultimedialeDto.getNome();
        Utente utente = utenteService.ottieniUtenteById(contenutoMultimedialeDto.getIdContributore());
        POI poi = consultazioneContenutiService.ottieniPOIdaId(contenutoMultimedialeDto.getIdPoi());
        Evento evento = consultazioneContenutiService.ottieniEventoDaId(contenutoMultimedialeDto.getIdEvento());
        Itinerario itinerario = consultazioneContenutiService.ottieniItinerarioDaId(contenutoMultimedialeDto.getIdItinerario());
        StatoElemento statoElemento;
        if(utente.getRuoli().contains(RuoliUtente.CURATORE.name())||utente.getRuoli().contains(RuoliUtente.CONTRIBUTORE_AUTORIZZATO.name())){
            statoElemento = StatoElemento.PUBBLICATO;
        }
        else {
            statoElemento = StatoElemento.PENDING;
        }
        if(poi!=null){
            Comune comune = poi.getComuneAssociato();
            return new ContenutoMultimediale(nome,utente,statoElemento,poi,comune);
        }
        else if(evento!=null){
            Comune comune = evento.getComuneAssociato();
            return new ContenutoMultimediale(nome,utente,statoElemento,evento,comune);
        }
        else {
            Comune comune = itinerario.getComuneAssociato();
            return new ContenutoMultimediale(nome,utente,statoElemento,itinerario,comune);
        }
    }


}
