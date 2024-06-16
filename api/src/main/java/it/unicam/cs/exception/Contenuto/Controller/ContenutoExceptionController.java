package it.unicam.cs.exception.Contenuto.Controller;

import it.unicam.cs.exception.Contenuto.*;
import it.unicam.cs.exception.Contenuto.ServiziNotValidException;
import it.unicam.cs.exception.Contenuto.TipoAmministrativoNotValidException;
import it.unicam.cs.exception.Contenuto.TipoIntrattenimentoNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ContenutoExceptionController {
    @ExceptionHandler(value = POINotFoundException.class)
    public ResponseEntity<Object> poiNotFoundException(POINotFoundException poiNotFoundException){
        return new ResponseEntity<>("poi non trovato", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = ContattiNonValidiException.class)
    public ResponseEntity<Object> contattiNotValidException(ContattiNonValidiException contattiNonValidiException){
        return new ResponseEntity<>("formato contatti non valido",HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ServiziNotValidException.class)
    public ResponseEntity<Object> serviziNotValidException(ServiziNotValidException serviziNotValidException){
        return new ResponseEntity<>("almeno un servizio inserito non esistente",HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = TipoAmministrativoNotValidException.class)
    public ResponseEntity<Object> tipoAmministrativoNotValidException (TipoAmministrativoNotValidException tipoAmministrativoNotValidException){
        return new ResponseEntity<>("tipo amministrativo non esistente", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = CollezioneNotValidException.class)
    public ResponseEntity<Object> collezioneNotValidException(CollezioneNotValidException collezioneNotValidException){
        return new ResponseEntity<>("almeno un elemento della collezione non presente", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = ServiziUtiliNotValidException.class)
    public ResponseEntity<Object> serviziUtiliNotValidException(ServiziUtiliNotValidException serviziUtiliNotValidException){
        return new ResponseEntity<>("almeno un elemento dei servizi utili non esistente", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = TipoPOINotValidException.class)
    public ResponseEntity<Object> tipoPOINotValidException(TipoPOINotValidException tipoPOINotValidException){
        return new ResponseEntity<>("tipo poi non esistente", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = TipoIntrattenimentoNotValidException.class)
    public ResponseEntity<Object> tipoIntrattenimentoNotValidException (TipoIntrattenimentoNotValidException tipoIntrattenimentoNotValidException){
        return new ResponseEntity<>("tipo intrattenimento non esistente", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = EventoNotFoundException.class)
    public ResponseEntity<Object> eventoNotFoundException(EventoNotFoundException eventoNotFoundException){
        return new ResponseEntity<>("evento non trovato", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = TipoTuristicoNotValidException.class)
    public ResponseEntity<Object> tipoTuristicoNotValidException(TipoTuristicoNotValidException tipoTuristicoNotValidException){
        return new ResponseEntity<>("tipo di turismo non esistente",HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = ItinerarioNotValidException.class)
    public ResponseEntity<Object> itinerarioNotValidException(ItinerarioNotValidException itinerarioNotValidException){
        return new ResponseEntity<>("i poi devono essere tutti all'interno dello stesso comune", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = POINotValidException.class)
    public ResponseEntity<Object> poiNotValidException (POINotValidException poiNotValidException){
        return new ResponseEntity<>("poi non appartennente al comune dell'utente", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = EventoNotValidException.class)
    public ResponseEntity<Object> eventoNotValidException(EventoNotValidException eventoNotValidException){
        return new ResponseEntity<>("evento non appartentente al comune dell'utente", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = ListaPOINotValidException.class)
    public ResponseEntity<Object> listaPOINotValidException(ListaPOINotValidException listaPOINotValidException){
        return new ResponseEntity<>("non ci possono essere poi duplicati nell'itinerario", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = TipoContenutoMultimedialeNotValidException.class)
    public ResponseEntity<Object> tipoContenutoMultimedialeNotValidException(TipoContenutoMultimedialeNotValidException tipoContenutoMultimedialeNotValidException){
        return new ResponseEntity<>("tipo contenuto multimediale non esistente", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = FotoNotValidExcetion.class)
    public ResponseEntity<Object> fotoNotValidException(FotoNotValidExcetion fotoNotValidExcetion){
        return new ResponseEntity<>("la foto deve essere un jpg, jpeg o png file",HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = PosizionePOINotValidException.class)
    public ResponseEntity<Object> posizionePOINotValidException(PosizionePOINotValidException posizionePOINotValidException){
        return new ResponseEntity<>("posizione poi fuori dal comune", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = PosizioneOccupataException.class)
    public ResponseEntity<Object> posizioneOccupataException(PosizioneOccupataException posizioneOccupataException){
        return new ResponseEntity<>("Esiste già un POI in questa posizione nel comune specificato.", HttpStatus.BAD_REQUEST);
    }
}
