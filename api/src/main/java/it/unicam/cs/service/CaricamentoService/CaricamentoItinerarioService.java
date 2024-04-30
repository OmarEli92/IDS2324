package it.unicam.cs.service.CaricamentoService;

import it.unicam.cs.Mediators.ItinerarioMediator;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.DTO.ItinerarioDto;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.repository.IPOIRepository;
import it.unicam.cs.repository.UtenteRepository;
import it.unicam.cs.service.ConsultazioneContenutiService;
import it.unicam.cs.service.ControlloService.ControlloItinerarioService;
import it.unicam.cs.service.UtenteService;
import it.unicam.cs.util.Extensions.ValidationItinerarioExtension;
import it.unicam.cs.util.enums.RuoliUtente;
import it.unicam.cs.util.enums.StatoElemento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaricamentoItinerarioService {
    @Autowired
    private ControlloItinerarioService controlloItinerarioService;
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private IPOIRepository poiRepository;
    @Autowired
    private ItinerarioMediator itinerarioMediator;
    public void caricaItinerario(ItinerarioDto itinerarioDto){
        controlloItinerarioService.controllaItinerario(itinerarioDto);
        Itinerario itinerario = costruisciItinerario(itinerarioDto);
        itinerarioMediator.salvaItinerario(itinerario);
    }

    private Itinerario costruisciItinerario(ItinerarioDto itinerarioDto) {
        List<POI> pois = poiRepository.findAllById(itinerarioDto.getPoisId());
        Utente utente = utenteService.ottieniUtenteById(itinerarioDto.getIDContributore());
        String nome = itinerarioDto.getNome();;
        String descrizione = itinerarioDto.getDescrizione();
        Comune comune = utente.getComuneAssociato();
        StatoElemento stato;
        if(utente.getRuoli().contains(RuoliUtente.CURATORE.name())|| utente.getRuoli().contains(RuoliUtente.CONTRIBUTORE_AUTORIZZATO.name())){
            stato = StatoElemento.PUBBLICATO;
        }
        else {
            stato = StatoElemento.PENDING;
        }
        Itinerario itinerario = new Itinerario(nome,utente,stato,comune,pois,descrizione);
        return itinerario;
    }

}
