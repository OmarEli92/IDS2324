package it.unicam.cs.Mediators;

import it.unicam.cs.model.contenuti.ContenutoContest;
import it.unicam.cs.service.ContestService;
import it.unicam.cs.service.POIService;
import it.unicam.cs.service.SalvataggioContenutiService;
import it.unicam.cs.service.UtenteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
public class ContenutoContestMediator {
    private UtenteService utenteService;
    private ContestService contestService;
    private SalvataggioContenutiService salvataggioContenutiService;

    public void salvaContenutoContest(ContenutoContest contenutoContest){
        contestService.aggiungiContenutoContest(contenutoContest.getContestAssociato().getId(), contenutoContest);
        utenteService.aggiungiContenutoContest(contenutoContest.getUtenteCreatore().getId(),contenutoContest);
        salvataggioContenutiService.salvaContenutoContest(contenutoContest);
    }

}
