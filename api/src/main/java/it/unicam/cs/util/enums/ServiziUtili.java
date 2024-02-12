package it.unicam.cs.util.enums;

public enum ServiziUtili {
    FARMACIA("Farmacia"),
    RISTORAZIONE("Ristorazione"),
    BAR("Bar"),
    BANCOMAT("Bancomat"),
    PARCHEGGIO("Parcheggio"),
    STAZIONE_SERVIZIO("Stazione di Servizio"),
    SUPERMERCATO("Supermercato");

    private final String descrizione;
    ServiziUtili(String descrizione){
        this.descrizione = descrizione;
    }
    public String getDescrizione(){
        return descrizione;
    }
}
