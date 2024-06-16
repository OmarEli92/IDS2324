package it.unicam.cs.Builder.POIBUILDER;

import it.unicam.cs.Visitor.POI.IPOIBuilderVisitor;
import it.unicam.cs.model.DTO.input.MonumentoDto;
import it.unicam.cs.model.DTO.input.PoiDto;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.Monumento;
import it.unicam.cs.util.enums.TipoPOI;

public class MonumentoBuilder extends POIBuilder {
    private int annoRealizzazione;
    private String descrizione;
    private String autore;
    private double altezza;
    private double lunghezza;
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

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    public void setLunghezza(double lunghezza) {
        this.lunghezza = lunghezza;
    }

    public void setArchitettura(String architettura) {
        this.architettura = architettura;
    }

    @Override
    public POI build() {
        return new Monumento(super.getNome(),super.getPosizione(), TipoPOI.MONUMENTO,super.getContributore(),super.getStato(),super.getComuneAssociato(), super.getEventiAssociati(),super.getContenutiMultimediali(),
                annoRealizzazione,descrizione,autore,altezza,lunghezza,architettura);
    }

    @Override
    public void accept(IPOIBuilderVisitor ipoiBuilderVisitor, PoiDto poiDto) {
        ipoiBuilderVisitor.visit(this, (MonumentoDto) poiDto);
    }
}
