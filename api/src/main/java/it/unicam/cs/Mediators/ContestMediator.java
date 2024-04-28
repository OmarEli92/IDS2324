package it.unicam.cs.Mediators;

import it.unicam.cs.model.Contest;
import it.unicam.cs.service.POIService;
import it.unicam.cs.service.SalvataggioContenutiService;
import it.unicam.cs.service.UtenteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
public class ContestMediator {
    private UtenteService utenteService;
    private POIService poiService;
    private SalvataggioContenutiService salvataggioContenutiService;

    public void salvaContest(Contest contest){
        salvataggioContenutiService.salvaContest(contest);
        utenteService.aggiungiContest(contest.getOrganizzatore().getId(),contest);
        poiService.salvaContest(contest.getPoiAssociato().getId(),contest);
    }
}
