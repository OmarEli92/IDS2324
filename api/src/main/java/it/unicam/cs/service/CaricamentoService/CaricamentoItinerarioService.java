package it.unicam.cs.service.CaricamentoService;

import it.unicam.cs.Mediators.ItinerarioMediator;
import it.unicam.cs.exception.UtenteNotValidException;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.DTO.input.ItinerarioDto;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.repository.IPOIRepository;
import it.unicam.cs.service.CaricamentoService.Interfaces.ICaricamentoItinerarioService;
import it.unicam.cs.service.ControlloService.ControlloItinerarioService;
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
public class CaricamentoItinerarioService implements ICaricamentoItinerarioService {
    @Autowired
    private ControlloItinerarioService controlloItinerarioService;
    @Autowired
    private IUtenteService utenteService;
    @Autowired
    private ItinerarioMediator itinerarioMediator;
    @Autowired
    private IPOIRepository poiRepository;
    @Override
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
        StatoElemento stato = isItinerarioContributoreValid(utente, comune);
        Itinerario itinerario = new Itinerario(nome,utente,stato,comune,pois,descrizione);
        return itinerario;
    }
    @Transactional
    private StatoElemento isItinerarioContributoreValid(Utente utente, Comune comune) {
        StatoElemento stato;
        List<String> nomi = utente.getRuoli()
                .stream()
                .map(Ruolo::getNome)
                .collect(Collectors.toList());
        List<Utente> utenti = comune.getListaUtenti();
        List<Utente> curatori = comune.getCuratori();
        if(!utenti.contains(utente) && !curatori.contains(utente)){
            throw new UtenteNotValidException("utente non appartiene al comune");
        }
        if(nomi.contains(RuoliUtente.CURATORE.name()) || nomi.contains(RuoliUtente.CONTRIBUTORE_AUTORIZZATO.name())){
            stato = StatoElemento.PUBBLICATO;
        }
        else{
            stato = StatoElemento.PENDING;
        }
        return stato;
    }
}
