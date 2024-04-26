package it.unicam.cs.Mediators;

import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.service.ComuneService;
import it.unicam.cs.service.SalvataggioContenutiService;
import it.unicam.cs.service.UtenteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
public class POIMediator {
    private ComuneService comuneService;
    private UtenteService utenteService;
    private SalvataggioContenutiService salvataggioContenutiService;

    public void salvaPOI(POI poi){
        salvataggioContenutiService.salvaPOI(poi);
        comuneService.aggiungiPOI(poi.getComuneAssociato().getId(),poi);
        utenteService.aggiungiPOI(poi.getContributore().getId(),poi);
    }
}
