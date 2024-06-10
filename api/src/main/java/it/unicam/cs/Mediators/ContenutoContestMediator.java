package it.unicam.cs.Mediators;

import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidComuneNotValidException;
import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidContenutoNotValidException;
import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidUtenteNotValidException;
import it.unicam.cs.model.Contest;
import it.unicam.cs.model.DTO.input.RichiestaValidazioneDto;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.contenuti.ContenutoContest;
import it.unicam.cs.service.*;
import it.unicam.cs.service.Interfaces.IConsultazioneContenutiService;
import it.unicam.cs.service.Interfaces.IContenutoContestService;
import it.unicam.cs.service.Interfaces.IContestService;
import it.unicam.cs.service.Interfaces.IUtenteService;
import it.unicam.cs.util.enums.RuoliUtente;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
public class ContenutoContestMediator {
    private IUtenteService utenteService;
    private IContestService contestService;
    private IContenutoContestService contenutoContestService;
    private IConsultazioneContenutiService consultazioneContenutiService;

    public void salvaContenutoContest(ContenutoContest contenutoContest){
        contenutoContestService.aggiungiContenutoContest(contenutoContest);
        contestService.aggiungiContenutoContest(contenutoContest.getContestAssociato().getId(), contenutoContest);
        utenteService.aggiungiContenutoContest(contenutoContest.getUtenteCreatore().getId(),contenutoContest);
    }
    @Transactional
    public void validaContenutoContest(RichiestaValidazioneDto richiestaValidazioneDto, Integer validatoreId){
        ContenutoContest contenutoContest = consultazioneContenutiService.ottieniContenutoContestDaid(richiestaValidazioneDto.getIdContenuto());
        Utente utente = utenteService.ottieniUtenteById(validatoreId);
        List<Integer> idContestCreati = utente.getContestCreati()
                .stream()
                .map(Contest::getId)
                .collect(Collectors.toList());
        if(contenutoContest.isPending()==true
        && idContestCreati.contains(contenutoContest.getContestAssociato().getId())
        ){
            utenteService.aggiornaListaContenutiContest(richiestaValidazioneDto.getIdContenuto(), richiestaValidazioneDto.isValidato());
            contestService.aggiornaListaContenutoContest(richiestaValidazioneDto.getIdContenuto(), richiestaValidazioneDto.isValidato());
            contenutoContestService.validaContenutoContest(richiestaValidazioneDto.getIdContenuto(), richiestaValidazioneDto.isValidato());
        }
        else if(!utente.getComuneAssociato().getId().equals(contenutoContest.getContestAssociato().getComuneAssociato().getId())){
            throw new RichiestaValidComuneNotValidException();
        }
        else if(!contenutoContest.isPending()){
            throw new RichiestaValidContenutoNotValidException();
        }
    }

}
