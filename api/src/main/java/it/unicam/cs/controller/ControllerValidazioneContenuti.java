package it.unicam.cs.controller;

import it.unicam.cs.model.DTO.input.RichiestaValidazioneDto;
import it.unicam.cs.security.JwtService;
import it.unicam.cs.service.Interfaces.IValidazioneContenutiService;
import it.unicam.cs.service.ValidazioneContenutiService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/validazione")
@AllArgsConstructor(onConstructor_ = @Autowired)
public class ControllerValidazioneContenuti {
    private final IValidazioneContenutiService validazioneContenutiService;
    private final JwtService jwtService;

    @PutMapping(value = "valida_poi")
    public ResponseEntity<Object> validaPOI(@RequestBody RichiestaValidazioneDto richiestaValidazioneDto, @RequestHeader("Authorization") String authorizationHeader){
        String token = authorizationHeader.substring(7);
        Integer validatoreId = jwtService.estraiId(token);
        validazioneContenutiService.validaPOI(richiestaValidazioneDto, validatoreId);
        if(richiestaValidazioneDto.isValidato()){
            return new ResponseEntity<>("poi validato", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("poi eliminato", HttpStatus.OK);
        }
    }
    @PutMapping(value = "valida_itinerario")
    public ResponseEntity<Object> validaItinerario(@RequestBody RichiestaValidazioneDto richiestaValidazioneDto, @RequestHeader("Authorization") String authorizationHeader){
        String token = authorizationHeader.substring(7);
        Integer validatoreId = jwtService.estraiId(token);
        validazioneContenutiService.validaEvento(richiestaValidazioneDto, validatoreId);
        validazioneContenutiService.validaItinerario(richiestaValidazioneDto, validatoreId);
        if(richiestaValidazioneDto.isValidato()){
            return new ResponseEntity<>("itinerario validato", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("itinerario eliminato", HttpStatus.OK);
        }
    }
    @PutMapping(value = "valida_evento")
    public ResponseEntity<Object> validaEvento(@RequestBody RichiestaValidazioneDto richiestaValidazioneDto, @RequestHeader("Authorization") String authorizationHeader){
        String token = authorizationHeader.substring(7);
        Integer userId = jwtService.estraiId(token);
        validazioneContenutiService.validaEvento(richiestaValidazioneDto, userId);
        if(richiestaValidazioneDto.isValidato()){
            return new ResponseEntity<>("evento validato", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("evento eliminato", HttpStatus.OK);
        }
    }
    @PutMapping(value = "valida_contenuto_multimediale")
    public ResponseEntity<Object> validaContenutoMultimediale(@RequestBody RichiestaValidazioneDto richiestaValidazioneDto, @RequestHeader("Authorization") String authorizationHeader){
        String token = authorizationHeader.substring(7);
        Integer validatoreId = jwtService.estraiId(token);
        validazioneContenutiService.validaContenutoMultimediale(richiestaValidazioneDto, validatoreId);
        if(richiestaValidazioneDto.isValidato()){
            return new ResponseEntity<>("contenuto multimediale validato", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("contenuto multimediale eliminato", HttpStatus.OK);
        }
    }
}
