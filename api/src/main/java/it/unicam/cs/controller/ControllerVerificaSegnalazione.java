package it.unicam.cs.controller;

import it.unicam.cs.model.DTO.input.EliminazioneContenutoDto;
import it.unicam.cs.security.JwtService;
import it.unicam.cs.service.EliminazioneContenutiService;
import it.unicam.cs.service.Interfaces.IEliminazioneContenutiService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping(value = "/api/verifica_segnalazione")
public class ControllerVerificaSegnalazione {
    private final IEliminazioneContenutiService eliminazioneContenutiService;
    private final JwtService jwtService;
    @PutMapping
    public ResponseEntity<Object> verificaSegnalazione(@RequestBody EliminazioneContenutoDto eliminazioneContenutoDto, @RequestHeader("Authorization") String authorizationHeader){
        String token = authorizationHeader.substring(7);
        Integer userId = jwtService.estraiId(token);
        eliminazioneContenutiService.accettaSegnalazioneContenuto(eliminazioneContenutoDto, userId);
        if(eliminazioneContenutoDto.isEliminato()){
            return new ResponseEntity<>("contenuto multimediale eliminato", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("contenuto multimediale di nuovo in stato di pubblicato", HttpStatus.OK);
        }
    }
}
