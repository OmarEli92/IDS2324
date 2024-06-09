package it.unicam.cs.controller;

import it.unicam.cs.model.DTO.input.EliminazioneContenutoDto;
import it.unicam.cs.service.EliminazioneContenutiService;
import it.unicam.cs.service.Interfaces.IEliminazioneContenutiService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping(value = "/api/verifica_segnalazione")
public class ControllerVerificaSegnalazione {
    private final IEliminazioneContenutiService eliminazioneContenutiService;
    @PutMapping
    public ResponseEntity<Object> verificaSegnalazione(@RequestBody EliminazioneContenutoDto eliminazioneContenutoDto){
        eliminazioneContenutiService.accettaSegnalazioneContenuto(eliminazioneContenutoDto);
        if(eliminazioneContenutoDto.isEliminato()){
            return new ResponseEntity<>("contenuto multimediale eliminato", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("contenuto multimediale di nuovo in stato di pubblicato", HttpStatus.OK);
        }
    }
}
