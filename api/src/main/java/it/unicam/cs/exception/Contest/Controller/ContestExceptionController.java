package it.unicam.cs.exception.Contest.Controller;

import ch.qos.logback.core.model.processor.ProcessorException;
import it.unicam.cs.exception.Contest.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ContestExceptionController {
    @ExceptionHandler(value = TipoInvitoException.class)
    public ResponseEntity<Object> tipoInvitoException(TipoInvitoException tipoInvitoException){
        return new ResponseEntity<>("il tipo di invito inserito non esiste", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = OrganizzatoreNotValidException.class)
    public ResponseEntity<Object> organizzatoreNotValidException(OrganizzatoreNotValidException organizzatoreNotValidException){
        return new ResponseEntity<>("l'utente deve avere tra i ruoli quello di animartore per inserire un contest", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = ListaPartecipantiNotValidException.class)
    public ResponseEntity<Object> listaPartecipantiException(ListaPartecipantiNotValidException listaPartecipantiNotValidException){
        return new ResponseEntity<>("nessun partecipante da aggiungere è esistente", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler( value = DataContestNotValidException.class)
    public ResponseEntity<Object> dataContestNotValidException(DataContestNotValidException dataContestNotValidException){
        return new ResponseEntity<>("contest chiuso, impossibile aggiungere utenti", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = ProprietaContestException.class)
    public ResponseEntity<Object> proprietaContestException(ProprietaContestException proprietaContestException){
        return new ResponseEntity<>("il contest inserito non è stato creato da te", HttpStatus.OK);
    }
}
