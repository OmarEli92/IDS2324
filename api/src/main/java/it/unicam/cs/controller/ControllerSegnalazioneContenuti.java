package it.unicam.cs.controller;

import it.unicam.cs.model.DTO.input.RichiestaSegnalazioneDto;
import it.unicam.cs.service.SegnalazioneService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/segnalazione")
@AllArgsConstructor(onConstructor_ = @Autowired)
public class ControllerSegnalazioneContenuti {
    private final SegnalazioneService segnalazioneService;

    @PutMapping
    public ResponseEntity<Object> segnalaContenutoMultimediale(@RequestBody RichiestaSegnalazioneDto richiestaSegnalazioneDto){
        segnalazioneService.segnalaContenutoMultimediale(richiestaSegnalazioneDto);
        return new ResponseEntity<>("contenuto multimediale segnalato", HttpStatus.OK);
    }
}