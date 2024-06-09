package it.unicam.cs.controller;

import it.unicam.cs.model.DTO.input.RichiestaValidazioneDto;
import it.unicam.cs.service.Interfaces.IValidazioneContenutiService;
import it.unicam.cs.service.ValidazioneContenutiService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/validazione")
@AllArgsConstructor(onConstructor_ = @Autowired)
public class ControllerValidazioneContenuti {
    private final IValidazioneContenutiService validazioneContenutiService;

    @PutMapping(value = "valida_poi")
    public ResponseEntity<Object> validaPOI(@RequestBody RichiestaValidazioneDto richiestaValidazioneDto){
        validazioneContenutiService.validaPOI(richiestaValidazioneDto);
        if(richiestaValidazioneDto.isValidato()){
            return new ResponseEntity<>("poi validato", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("poi eliminato", HttpStatus.OK);
        }
    }
    @PutMapping(value = "valida_itinerario")
    public ResponseEntity<Object> validaItinerario(@RequestBody RichiestaValidazioneDto richiestaValidazioneDto){
        validazioneContenutiService.validaItinerario(richiestaValidazioneDto);
        if(richiestaValidazioneDto.isValidato()){
            return new ResponseEntity<>("itinerario validato", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("itinerario eliminato", HttpStatus.OK);
        }
    }
    @PutMapping(value = "valida_evento")
    public ResponseEntity<Object> validaEvento(@RequestBody RichiestaValidazioneDto richiestaValidazioneDto){
        validazioneContenutiService.validaEvento(richiestaValidazioneDto);
        if(richiestaValidazioneDto.isValidato()){
            return new ResponseEntity<>("evento validato", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("evento eliminato", HttpStatus.OK);
        }
    }
    @PutMapping(value = "valida_contenuto_multimediale")
    public ResponseEntity<Object> validaContenutoMultimediale(@RequestBody RichiestaValidazioneDto richiestaValidazioneDto){
        validazioneContenutiService.validaContenutoMultimediale(richiestaValidazioneDto);
        if(richiestaValidazioneDto.isValidato()){
            return new ResponseEntity<>("contenuto multimediale validato", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("contenuto multimediale eliminato", HttpStatus.OK);
        }
    }
}
