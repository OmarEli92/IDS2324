package it.unicam.cs.service.CaricamentoService;

import it.unicam.cs.model.Contest;
import it.unicam.cs.model.DTO.ContenutoContestDto;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.contenuti.ContenutoContest;
import it.unicam.cs.repository.IContestRepository;
import it.unicam.cs.repository.UtenteRepository;
import it.unicam.cs.service.ContestService;
import it.unicam.cs.service.ControlloService.ControlloContenutoContestService;
import it.unicam.cs.service.UtenteService;
import it.unicam.cs.util.enums.TipoContenuto;
import org.springframework.beans.factory.annotation.Autowired;

public class CaricamentoContenutoContest {
    @Autowired
    ControlloContenutoContestService controlloContenutoContestService;
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private ContestService contestService;

    public void caricaContenutoContest(ContenutoContestDto contenutoContestDto){
        controlloContenutoContestService.verificaContenutoContest(contenutoContestDto);
        ContenutoContest contenutoContest = new ContenutoContest();
        costruisciContenutoContest(contenutoContestDto, contenutoContest);
    }

    private void costruisciContenutoContest(ContenutoContestDto contenutoContestDto, ContenutoContest contenutoContest) {
        Utente utente = utenteService.ottieniUtenteById(contenutoContestDto.getIdUtente());
        Contest contest = contestService.ottieniContest(contenutoContestDto.getIdContestAssociato());
        contenutoContest.setNome(contenutoContest.getNome());
        contenutoContest.setTipo(TipoContenuto.valueOf(contenutoContestDto.getTipoContenuto().toUpperCase()));
        contenutoContest.setUtenteCreatore(utente);
        contenutoContest.setContestAssociato(contest);
    }

}
