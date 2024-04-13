package it.unicam.cs.Builder;

import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.POIAmministrativo;
import it.unicam.cs.util.info.Contatti;
import org.springframework.stereotype.Component;

@Component
public class POIAmministrativoBuilder extends POIBuilder {
    private String orariApertura;
    private String responsabile;
    private Contatti contatti;

    public void setOrariApertura(String orariApertura) {
        this.orariApertura = orariApertura;
    }

    public void setResponsabile(String responsabile) {
        this.responsabile = responsabile;
    }

    public void setContatti(Contatti contatti) {
        this.contatti = contatti;
    }

    @Override
    POI build() {
        return new POIAmministrativo(super.getId(),super.getNome(),super.getPosizione(),
                super.getContributore(),super.getComuneAssociato(),super.getIndirizzo(),super
                .getContenutiMultimediali(),super.getEventiAssociati(),orariApertura,responsabile,contatti);
    }
}
