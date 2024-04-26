package it.unicam.cs.service.CaricamentoService;

import it.unicam.cs.model.Contest;
import it.unicam.cs.model.DTO.ContestDto;
import it.unicam.cs.model.Utente;
import it.unicam.cs.repository.UtenteRepository;
import it.unicam.cs.service.ControlloService.ControlloContestService;
import it.unicam.cs.util.enums.TipoInvito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaricamentoContestService {
    @Autowired
    ControlloContestService controlloContestService;
    @Autowired
    UtenteRepository utenteRepository;

    public void caricaContest(ContestDto contestDto){
        controlloContestService.verificaContest(contestDto);
        Contest contest = new Contest();
        costruisciContest(contest,contestDto);
    }

    private void costruisciContest(Contest contest,ContestDto contestDto) {
        Utente utente = utenteRepository.findUtenteById(contestDto.getIdOrganizzatore());
        contest.setDescrizione(contestDto.getDescrizione());
        contest.setDataInizio(contestDto.getDataInizio());
        contest.setDataFine(contestDto.getDataFine());
        if(contestDto.getTipoInvito().equalsIgnoreCase("invito")){
            contest.setPartecipanti(contestDto.getPartecipanti());
        }
        contest.setComuneAssociato(utente.getComuneAssociato());
        contest.setOrganizzatore(utente);
        contest.setTipoInvito(TipoInvito.valueOf(contestDto.getTipoInvito().toUpperCase()));
    }
}
