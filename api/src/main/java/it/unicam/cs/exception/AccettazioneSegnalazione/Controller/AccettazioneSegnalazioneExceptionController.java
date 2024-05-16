package it.unicam.cs.exception.AccettazioneSegnalazione.Controller;

import it.unicam.cs.exception.AccettazioneSegnalazione.AccettSegnalazioneUtenteNotValidException;
import it.unicam.cs.exception.AccettazioneSegnalazione.ContenutoMultimedialeNonSegnalatoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AccettazioneSegnalazioneExceptionController {
    @ExceptionHandler(value = ContenutoMultimedialeNonSegnalatoException.class)
    public ResponseEntity<Object> contenutoMultimedialeNonSegnalatoException (ContenutoMultimedialeNonSegnalatoException contenutoMultimedialeNonSegnalatoException){
        return new ResponseEntity<>("contenuto multimediale non segnalato", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = AccettSegnalazioneUtenteNotValidException.class)
    public ResponseEntity<Object> utenteNotValidException (AccettSegnalazioneUtenteNotValidException accettSegnalazioneUtenteNotValidException){
        return new ResponseEntity<>("l'utente non è un curatore, non può acettare una segnalazione", HttpStatus.UNAUTHORIZED);
    }
}
