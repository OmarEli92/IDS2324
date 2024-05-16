package it.unicam.cs.exception.RichiestaSegnalazione.Controller;

import it.unicam.cs.exception.RichiestaSegnalazione.ContenutoMultimedialeDaSegnalareException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RichiestaSegnalazioneException {
    @ExceptionHandler(value = ContenutoMultimedialeDaSegnalareException.class)
    public ResponseEntity<Object> contenutoMultimedialeDaSegnalareException(ContenutoMultimedialeDaSegnalareException contenutoMultimedialeGiaSegnalatoException){
        return new ResponseEntity<>("contenuto multimediale o già segnalato o non pubblicato", HttpStatus.BAD_REQUEST);
    }
}
