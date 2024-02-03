package it.unicam.cs.util;

public enum TipoTuristico {
    MUSEO("Museo"),
    PARCO("Parco"),
    MONUMENTO("Monumento");

    private final String descrizione;

    TipoTuristico(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }
}
