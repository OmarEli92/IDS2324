package it.unicam.cs.util;

import jakarta.persistence.Embeddable;

@Embeddable
public class Indirizzo {
    private String via;
    private String numeroCivico;
    private String cap;
}
