package it.unicam.cs.Mediators;

import it.unicam.cs.model.Contest;
import it.unicam.cs.model.Utente;
import it.unicam.cs.repository.IContestRepository;
import it.unicam.cs.service.*;
import it.unicam.cs.service.Interfaces.IComuneService;
import it.unicam.cs.service.Interfaces.IContestService;
import it.unicam.cs.service.Interfaces.IPOIService;
import it.unicam.cs.service.Interfaces.IUtenteService;
import it.unicam.cs.util.VerificaSomiglianzaContenuti;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
public class ContestMediator {
    private IUtenteService utenteService;
    private IContestService contestService;
    private IPOIService poiService;
    private IComuneService comuneService;
    private IContestRepository contestRepository;

    public void salvaContest(Contest contest){
        contestService.aggiungiContest(contest);
        utenteService.aggiungiContest(contest.getOrganizzatore().getId(),contest);
        poiService.salvaContest(contest.getPoiAssociato().getId(),contest);
        comuneService.aggiungiContest(contest.getComuneAssociato().getId(), contest);
    }


    @Transactional
    @Scheduled(cron = "0 0 0 * * *")
    public void verificaScadenze(){
        LocalDate oggi = LocalDate.now();
        List<Contest> contestScaduti = contestRepository.findByDataFineBeforeAndAttivoIsTrue(oggi);
        contestScaduti.forEach(contest -> {contestService.chiudiContest(contest);
            List<Utente> utenti = contest.getPartecipantiContest();
                poiService.aggiornaListaContestDaChiudere(contest.getId());
                utenteService.aggiornaListaContestDaChiudere(contest.getId());
                comuneService.aggiornaListaContestDaChiudere(contest.getId());
        });

    }
    @Transactional
    @Scheduled(cron = "0 0 0 * * *")
    public void verificaAperture(){
        LocalDate oggi = LocalDate.now();
        List<Contest> contestDaAprire = contestRepository.findByDataInizioBeforeAndAttivoIsFalse(oggi);
        contestDaAprire.forEach(contest -> {contestService.apriContest(contest);
            poiService.aggiornaListaContestAperti(contest.getId());
            utenteService.aggiornaListaContestCreatiAperti(contest.getId());
            utenteService.aggiornaListaContestInPartecipazioneAperti(contest.getId());
            comuneService.aggiornaListaContestDaAprire(contest.getId());
        });
    }
}
