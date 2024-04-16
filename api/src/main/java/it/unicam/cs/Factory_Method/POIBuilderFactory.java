package it.unicam.cs.Factory_Method;

import it.unicam.cs.Builder.*;
import it.unicam.cs.model.DTO.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class POIBuilderFactory {
    private final POIAmministrativoBuilder poiAmministrativoBuilder;
    private final POIIntrattenimentoBuilder poiIntrattenimentoBuilder;
    private final POIServiziUtiliBuilder poiServiziUtiliBuilder;
    private final MonumentoBuilder monumentoBuilder;
    private final MuseoBuilder museoBuilder;
    private final ParcoBuilder parcoBuilder;

    public POIBuilder createBuilder(PoiDto poiDto){
        if(poiDto instanceof MuseoDto){
            return museoBuilder;
        }
        else if(poiDto instanceof PoiAmministrativoDto){
            return poiAmministrativoBuilder;
        }
        else if(poiDto instanceof PoiIntrattenimentoDto){
            return poiIntrattenimentoBuilder;
        }
        else if(poiDto instanceof PoiServiziUtiliDto){
            return poiServiziUtiliBuilder;
        }
        else if (poiDto instanceof MonumentoDto) {
            return monumentoBuilder;
        }
        else if (poiDto instanceof ParcoDto){
            return parcoBuilder;
        }
        else throw new IllegalArgumentException("tipo di poi non esistente");
    }
}
