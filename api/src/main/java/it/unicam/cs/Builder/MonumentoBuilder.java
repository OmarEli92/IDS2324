package it.unicam.cs.Builder;

import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.Monumento;

public class MonumentoBuilder extends POIBuilder {
    private int annoRealizzazione;
    private String descrizione;
    private String autore;
    private int altezza;
    private int lunghezza;
    private String architettura;

    public void setAnnoRealizzazione(int annoRealizzazione) {
        this.annoRealizzazione = annoRealizzazione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void setAltezza(int altezza) {
        this.altezza = altezza;
    }

    public void setLunghezza(int lunghezza) {
        this.lunghezza = lunghezza;
    }

    public void setArchitettura(String architettura) {
        this.architettura = architettura;
    }

    @Override
    POI build() {
        return new Monumento(super.getId(),super.getNome(),super.getPosizione(),super.getContributore(),super.getComuneAssociato(),
                super.getIndirizzo(),super.getContenutiMultimediali(),super.getEventiAssociati(),
                annoRealizzazione,descrizione,autore,altezza,lunghezza,architettura);
    }
}
