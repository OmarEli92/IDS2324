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
}
