package it.unicam.cs.util;

/** I tipi di POI amministrativi nel comune*/

public enum TipoAmministrativo {
    MUNICIPIO("Municipio"),
    UFFICIO_POSTALE("Ufficio Postale"),
    UFFICIO_ANAGRAFE("Ufficio Anagrafe"),
    OSPEDALE("Ospedale"),
    POLIZIA("Polizia"),
    VIGILI_DEL_FUOCO("Vigili del Fuoco"),
    CARABINIERI("Carabinieri"),
    GUARDIA_DI_FINANZA("Guardia di Finanza"),
    TRIBUNALE("Tribunale");

    private final String descrizione;

    TipoAmministrativo(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }
}
