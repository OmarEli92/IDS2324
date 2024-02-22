package it.unicam.cs.util.enums;

public enum TipoContenutoMultimediale {
    FOTO("Foto"),
    LINK("Link");
    private final String descrizione;

    TipoContenutoMultimediale(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }
}
