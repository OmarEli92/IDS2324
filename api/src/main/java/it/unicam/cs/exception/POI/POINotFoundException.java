package it.unicam.cs.exception.POI;

public class POINotFoundException extends RuntimeException {
    public POINotFoundException(String message) {
        super(message);
    }
}
