package it.unicam.cs.Builder;

import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.POIServiziUtili;
import it.unicam.cs.util.info.Contatti;
import org.springframework.stereotype.Component;

@Component
public class POIServiziUtiliBuilder extends POIBuilder{
    private Contatti contatti;
    private String orariApertura;

    public void setContatti(Contatti contatti) {
        this.contatti = contatti;
    }

    public void setOrariApertura(String orariApertura) {
        this.orariApertura = orariApertura;
    }

    @Override
    POI build() {
        return new POIServiziUtili(super.getId(),super.getNome(),super.getPosizione(),super.getContributore(),
                super.getComuneAssociato(),super.getIndirizzo(),super.getContenutiMultimediali(),super.getEventiAssociati(),contatti,orariApertura);
    }
}
