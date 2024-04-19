package it.unicam.cs.exception.POI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class POIExceptionController {
    @ExceptionHandler(value = POINotFoundException.class)
    public ResponseEntity<Object> poiNotFoundException(POINotFoundException poiNotFoundException){
        return new ResponseEntity<>("poi non trovato", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = ContattiNonValidiException.class)
    public ResponseEntity<Object> contattiNotValidException(ContattiNonValidiException contattiNonValidiException){
        return new ResponseEntity<>("formato contatti non valido",HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = EstensioneNotValidException.class)
    public ResponseEntity<Object> estensioneNotValidException(EstensioneNotValidException estensioneNotValidException){
        return new ResponseEntity<>("estensione non valida, deve essere > 0", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = EtaConsigliataNonValidaException.class)
    public ResponseEntity<Object> etaConsigliataNotValidException (EtaConsigliataNonValidaException etaConsigliataNonValidaException){
        return new ResponseEntity<>("eta non valida, deve essere > 0", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = NamePOINotValidException.class)
    public ResponseEntity<Object> namePOINotValidException(NamePOINotValidException namePOINotValidException){
        return new ResponseEntity<>("nome POI non valido",HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = OrariAperturaNotValidException.class)
    public ResponseEntity<Object> orariAperturaNotValidException(OrariAperturaNotValidException orariAperturaNotValidException){
        return new ResponseEntity<>("formato orari apertura non valido", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = ResponsabilePOINotValidException.class)
    public ResponseEntity<Object> responsabileNotValidException(ResponsabilePOINotValidException responsabilePOINotValidException){
        return new ResponseEntity<>("stringa non valida", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = ServiziNotValidException.class)
    public ResponseEntity<Object> serviziNotValidException(ServiziNotValidException serviziNotValidException){
        return new ResponseEntity<>("almeno un servizio inserito non esistente",HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = TipoAmministrativoNotValidException.class)
    public ResponseEntity<Object> tipoAmministrativoNotValidException (TipoAmministrativoNotValidException tipoAmministrativoNotValidException){
        return new ResponseEntity<>("tipo amministrativo non esistente", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = NumeroSaleNotValidException.class)
    public ResponseEntity<Object> numeroSaleNotValidException(NumeroSaleNotValidException numeroSaleNotValidException){
        return new ResponseEntity<>("il numero deve essere > 0", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = CollezioneNotValidException.class)
    public ResponseEntity<Object> collezioneNotValidException(CollezioneNotValidException collezioneNotValidException){
        return new ResponseEntity<>("almeno un elemento della collezione non presente", HttpStatus.BAD_REQUEST);
    }
}
