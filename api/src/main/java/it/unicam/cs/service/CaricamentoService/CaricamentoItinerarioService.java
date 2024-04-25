package it.unicam.cs.service.CaricamentoService;

import it.unicam.cs.model.DTO.ItinerarioDto;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.repository.UtenteRepository;
import it.unicam.cs.service.ControlloService.ControlloItinerarioService;
import it.unicam.cs.util.Extensions.ValidationItinerarioExtension;
import it.unicam.cs.util.enums.StatoElemento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaricamentoItinerarioService {
    @Autowired
    ControlloItinerarioService controlloItinerarioService;
    @Autowired
    UtenteRepository utenteRepository;

    public void caricaItinerario(ItinerarioDto itinerarioDto){
        controlloItinerarioService.controllaItinerario(itinerarioDto);
        costruisciItinerario(itinerarioDto);
    }

    private void costruisciItinerario(ItinerarioDto itinerarioDto) {
        Itinerario itinerario = new Itinerario();
        Utente utente = utenteRepository.findUtenteById(itinerarioDto.getIDContributore());
        itinerario.setNome(itinerarioDto.getNome());
        itinerario.setDescirizione(itinerarioDto.getDescrizione());
        itinerario.setContributore(utente);
        itinerario.setStato(utente);
        itinerario.setComuneAssociato(utente.getComuneAssociato());
        itinerario.setPoisAssociati(new ArrayList<POI>());
    }

}
