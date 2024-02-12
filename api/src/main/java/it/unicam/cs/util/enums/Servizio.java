package it.unicam.cs.util.enums;
/** Lista di servizi offerti nei POI di intrattenimento**/
public enum Servizio {
    WIFI("Wi-Fi"),
    PARCHEGGIO("Parcheggio"),
    ACCESSIBILE_DISABILI("Accessibile Disabili"),
    SPETTACOLI("Spettacoli"),
    SPETTACOLI_MUSICALI("Spettacoli Musicali"),
    SPETTACOLI_TEATRALI("Spettacoli Teatrali"),
    EVENTI_SPECIALI("Eventi Speciali"),
    EVENTI_CULTURALI("Eventi Culturali"),
    EVENTI_SPORTIVI("Eventi Sportivi"),
    RISTORANTE("Ristorante"),
    BAR("Bar"),
    PISCINA("Piscina"),
    PALESTRA("Palestra"),
    SPA("Spa"),
    CAMERE("Camere"),
    ANIMAZIONE("Animazione"),
    ALTRO("Altro");

    private final String descrizione;

    Servizio(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }
}
