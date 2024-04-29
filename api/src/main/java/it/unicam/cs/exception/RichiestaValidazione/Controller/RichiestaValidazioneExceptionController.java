package it.unicam.cs.exception.RichiestaValidazione.Controller;

import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidComuneNotValidException;
import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidContenutoNotValidException;
import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidUtenteNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RichiestaValidazioneExceptionController {
    @ExceptionHandler(value = RichiestaValidUtenteNotValidException.class)
    public ResponseEntity<Object> richiestaUtenteNotValidException(RichiestaValidUtenteNotValidException richiestaValidUtenteNotValidException){
        return new ResponseEntity<>("l'utente non è un curatore", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = RichiestaValidComuneNotValidException.class)
    public ResponseEntity<Object> richiestaComuneNotValidException(RichiestaValidComuneNotValidException richiestaValidComuneNotValidException){
        return new ResponseEntity<>("il contenuto da validare non fa parte del comune dell'utente", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = RichiestaValidContenutoNotValidException.class)
    public ResponseEntity<Object> richiestaContenutoNotValidExcetion(RichiestaValidContenutoNotValidException richiestaValidContenutoNotValidException){
        return new ResponseEntity<>("il contenuto è già stato validato", HttpStatus.BAD_REQUEST);
    }
}
