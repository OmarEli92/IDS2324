package it.unicam.cs.service.CaricamentoService;

import it.unicam.cs.Mediators.ContestMediator;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Contest;
import it.unicam.cs.model.DTO.input.ContestDto;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.service.ConsultazioneContenutiService;
import it.unicam.cs.service.ControlloService.ControlloContestService;
import it.unicam.cs.service.UtenteService;
import it.unicam.cs.util.enums.TipoInvito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CaricamentoContestService {
    @Autowired
    private ControlloContestService controlloContestService;
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private ConsultazioneContenutiService consultazioneContenutiService;
    @Autowired
    private ContestMediator contestMediator;

    public void caricaContest(ContestDto contestDto){
        controlloContestService.verificaContest(contestDto);
        Contest contest = costruisciContest(contestDto);
        contestMediator.salvaContest(contest);
    }

    private Contest costruisciContest(ContestDto contestDto) {
        Utente utente = utenteService.ottieniUtenteById(contestDto.getIdOrganizzatore());
        POI poi = consultazioneContenutiService.ottieniPOIdaId(contestDto.getIdPoiAssociato());
        String descrizione = contestDto.getDescrizione();
        LocalDate dataInizio = contestDto.getDataInizio();
        LocalDate dataFine = contestDto.getDataFine();
        boolean attivo;
        LocalDate oggi = LocalDate.now();
        if(dataInizio.isAfter(oggi)){
            attivo = false;
        }
        else {
            attivo = true;
        }
        TipoInvito tipoInvito = TipoInvito.valueOf(contestDto.getTipoInvito().toUpperCase());
        int partecipanti;
        if(tipoInvito.name().equals("INVITO")){
            partecipanti = contestDto.getPartecipanti();
        }
        else {
            partecipanti = Integer.MAX_VALUE;
        }
        Comune comune = poi.getComuneAssociato();
        Contest contest = new Contest(descrizione,dataInizio,dataFine,partecipanti,poi,comune,utente,attivo,tipoInvito);
        return contest;
    }
}
