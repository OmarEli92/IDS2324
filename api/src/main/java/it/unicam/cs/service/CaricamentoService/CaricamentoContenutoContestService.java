package it.unicam.cs.service.CaricamentoService;

import it.unicam.cs.Mediators.ContenutoContestMediator;
import it.unicam.cs.model.Contest;
import it.unicam.cs.model.DTO.input.ContenutoContestDto;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.contenuti.ContenutoContest;
import it.unicam.cs.service.ContestService;
import it.unicam.cs.service.ControlloService.ControlloContenutoContestService;
import it.unicam.cs.service.UtenteService;
import it.unicam.cs.util.enums.TipoContenuto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaricamentoContenutoContestService {
    @Autowired
    ControlloContenutoContestService controlloContenutoContestService;
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private ContestService contestService;
    @Autowired
    private ContenutoContestMediator contenutoContestMediator;

    public void caricaContenutoContest(ContenutoContestDto contenutoContestDto){
        controlloContenutoContestService.verificaContenutoContest(contenutoContestDto);
        ContenutoContest contenutoContest =  costruisciContenutoContest(contenutoContestDto);
        contenutoContestMediator.salvaContenutoContest(contenutoContest);
    }

    private ContenutoContest costruisciContenutoContest(ContenutoContestDto contenutoContestDto) {
        Utente utente = utenteService.ottieniUtenteById(contenutoContestDto.getIdUtente());
        Contest contest = contestService.ottieniContest(contenutoContestDto.getIdContestAssociato());
        String nome = contenutoContestDto.getNome();
        TipoContenuto tipo = TipoContenuto.valueOf(contenutoContestDto.getTipoContenuto().toUpperCase());
        ContenutoContest contenutoContest = new ContenutoContest(nome,tipo,utente,contest);
        return contenutoContest;
    }

}
