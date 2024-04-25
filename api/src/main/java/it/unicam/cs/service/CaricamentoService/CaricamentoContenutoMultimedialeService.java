package it.unicam.cs.service.CaricamentoService;

import it.unicam.cs.model.DTO.ContenutoMultimedialeDto;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.repository.IEventoRepository;
import it.unicam.cs.repository.IPOIRepository;
import it.unicam.cs.repository.UtenteRepository;
import it.unicam.cs.service.ControlloService.ControlloContenutoMultimedialeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CaricamentoContenutoMultimedialeService {
    @Autowired
    private ControlloContenutoMultimedialeService controlloContenutoMultimedialeService;
    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private IPOIRepository poiRepository;
    @Autowired
    private IEventoRepository eventoRepository;

    public void caricaContenutoMultimediale(ContenutoMultimedialeDto contenutoMultimedialeDto){
        controlloContenutoMultimedialeService.verificaContenutoMultimediale(contenutoMultimedialeDto);
        ContenutoMultimediale contenutoMultimediale = new ContenutoMultimediale();
        costruisciContenutoMultimediale(contenutoMultimediale,contenutoMultimedialeDto);
    }

    private void costruisciContenutoMultimediale(ContenutoMultimediale contenutoMultimediale,ContenutoMultimedialeDto contenutoMultimedialeDto) {
        Utente utente = utenteRepository.findUtenteById(contenutoMultimedialeDto.getIdContributore());
        POI poi = poiRepository.findPoiById(contenutoMultimedialeDto.getIdPoi());
        Evento evento = eventoRepository.findEventoById(contenutoMultimedialeDto.getIdEvento());
        contenutoMultimediale.setNome(contenutoMultimedialeDto.getNome());
        contenutoMultimediale.setUtenteCreatore(utente);
        contenutoMultimediale.setStato(utente);
        contenutoMultimediale.setPoiAssociato(poi);
        contenutoMultimediale.setEventoAssociato(evento);
    }
}
