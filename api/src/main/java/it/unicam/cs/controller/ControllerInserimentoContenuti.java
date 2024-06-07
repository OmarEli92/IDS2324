package it.unicam.cs.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.media.Schema;
import it.unicam.cs.model.DTO.input.ContenutoMultimedialeDto;
import it.unicam.cs.model.DTO.input.EventoDto;
import it.unicam.cs.model.DTO.input.ItinerarioDto;
import it.unicam.cs.model.DTO.input.PoiDto;
import it.unicam.cs.service.CaricamentoService.CaricamentoContenutoMultimedialeService;
import it.unicam.cs.service.CaricamentoService.CaricamentoEventoService;
import it.unicam.cs.service.CaricamentoService.CaricamentoItinerarioService;
import it.unicam.cs.service.CaricamentoService.CaricamentoPOIService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping(value = "/api/inserimento")
public class ControllerInserimentoContenuti {
    private CaricamentoContenutoMultimedialeService caricamentoContenutoMultimedialeService;
    private CaricamentoEventoService caricamentoEventoService;
    private CaricamentoItinerarioService caricamentoItinerarioService;
    private CaricamentoPOIService caricamentoPOIService;

    @PostMapping(value = "aggiungi_poi")
    public ResponseEntity<Object> aggiungiPOI(@RequestBody PoiDto poiDto){
        caricamentoPOIService.caricaPOI(poiDto);
        return new ResponseEntity<>("poi aggiunto", HttpStatus.CREATED);
    }
    @PostMapping(value = "aggiungi_itinerario")
    public ResponseEntity<Object> aggiungiItinerario(@RequestBody ItinerarioDto itinerarioDto){
        caricamentoItinerarioService.caricaItinerario(itinerarioDto);
        return new ResponseEntity<>("itinerario aggiunto",HttpStatus.CREATED);
    }
    @PostMapping(value = "aggiungi_evento")
    public ResponseEntity<Object> aggiungiEvento(@RequestBody EventoDto eventoDto){
        caricamentoEventoService.caricaEvento(eventoDto);
        return new ResponseEntity<>("evento aggiunto", HttpStatus.CREATED);
    }
    @PostMapping(value = "aggiungi_contenuto_multimediale")
    public ResponseEntity<Object> aggiungiContenutoMultimediale(@RequestBody ContenutoMultimedialeDto contenutoMultimedialeDto){
        caricamentoContenutoMultimedialeService.caricaContenutoMultimediale(contenutoMultimedialeDto);
        return new ResponseEntity<>("contenuto multimediale aggiunto", HttpStatus.CREATED);
    }
    
}
