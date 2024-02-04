package it.unicam.cs.util;
/** I tipi di collezioni presenti nel museo*/
public enum CollezioniMuseo {
    ARTE_CONTEMPORANEA("Arte Contemporanea"),
    ARTE_ANTICA("Arte Antica"),
    ARCHEOLOGIA("Archeologia"),
    STORIA("Storia"),
    SCIENZA("Scienza"),
    ETNOGRAFIA("Etnografia"),
    PARCO("Parco");


    private final String descrizione;

    CollezioniMuseo(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }
}
