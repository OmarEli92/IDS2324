package it.unicam.cs.util.info;

import jakarta.persistence.Embeddable;

@Embeddable
public class Indirizzo {
    private String via;
    private String numeroCivico;
    private String cap;
}
