package it.unicam.cs.exception;

public class UtenteNotValidException extends RuntimeException{
    public UtenteNotValidException(String message) {
        super(message);
    }
}
