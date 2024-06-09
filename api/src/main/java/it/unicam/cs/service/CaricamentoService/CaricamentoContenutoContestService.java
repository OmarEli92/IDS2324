package it.unicam.cs.service.CaricamentoService;

import it.unicam.cs.Mediators.ContenutoContestMediator;
import it.unicam.cs.model.Contest;
import it.unicam.cs.model.DTO.input.ContenutoContestDto;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.contenuti.ContenutoContest;
import it.unicam.cs.service.CaricamentoService.Interfaces.ICaricamentoContenutoContestService;

import it.unicam.cs.service.ControlloService.ControlloContenutoContestService;
import it.unicam.cs.service.Interfaces.IContestService;
import it.unicam.cs.service.Interfaces.IUtenteService;
import it.unicam.cs.util.enums.TipoContenuto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaricamentoContenutoContestService implements ICaricamentoContenutoContestService {
    @Autowired
    ControlloContenutoContestService controlloContenutoContestService;
    @Autowired
    private IUtenteService utenteService;
    @Autowired
    private IContestService contestService;
    @Autowired
    private ContenutoContestMediator contenutoContestMediator;
    @Override
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
