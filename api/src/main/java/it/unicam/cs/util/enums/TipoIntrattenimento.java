package it.unicam.cs.util.enums;
/** I tipi di intrattenimento associati a POI nel comune*/
public enum TipoIntrattenimento {
    CINEMA("Cinema"),
    TEATRO("Teatro"),
    DISCOTECA("Discoteca"),
    PARCO_DIVERTIMENTI("Parco Divertimenti"),
    STADIO("Stadio"),
    CENTRO_COMMERCIALE("Centro Commerciale"),
    CENTRO_BENESSERE("Centro Benessere"),
    CENTRO_SPORTIVO("Centro Sportivo"),
    CENTRO_RICREATIVO("Centro Ricreativo");

    private final String descrizione;

    TipoIntrattenimento(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }
}
