package it.unicam.cs.Builder;

import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.POIIntrattenimento;
import it.unicam.cs.util.enums.Servizio;
import it.unicam.cs.util.info.Contatti;

import java.util.List;

public class POIIntrattenimentoBuilder extends POIBuilder{
    private int etaConsigliata;
    private String orariApertura;
    private List<Servizio> serviziOfferti;
    private Contatti contatti;

    public void setEtaConsigliata(int etaConsigliata) {
        this.etaConsigliata = etaConsigliata;
    }

    public void setOrariApertura(String orariApertura) {
        this.orariApertura = orariApertura;
    }

    public void setServiziOfferti(List<Servizio> serviziOfferti) {
        this.serviziOfferti = serviziOfferti;
    }

    public void setContatti(Contatti contatti) {
        this.contatti = contatti;
    }

    @Override
    POI build() {
        return new POIIntrattenimento(super.getId(),super.getNome(),super.getPosizione(),
                super.getContributore(),super.getComuneAssociato(),super.getIndirizzo(),super.getContenutiMultimediali(),
                super.getEventiAssociati(),etaConsigliata,orariApertura,serviziOfferti,contatti);
    }
}
