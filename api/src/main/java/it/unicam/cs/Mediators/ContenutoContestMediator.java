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
    private UtenteService utenteService;
    private ContestService contestService;
    private ContenutoContestService contenutoContestService;
    private ConsultazioneContenutiService consultazioneContenutiService;

    public void salvaContenutoContest(ContenutoContest contenutoContest){
        contenutoContestService.aggiungiContenutoContest(contenutoContest);
        contestService.aggiungiContenutoContest(contenutoContest.getContestAssociato().getId(), contenutoContest);
        utenteService.aggiungiContenutoContest(contenutoContest.getUtenteCreatore().getId(),contenutoContest);
    }
    @Transactional
    public void validaContenutoContest(RichiestaValidazioneDto richiestaValidazioneDto){
        ContenutoContest contenutoContest = consultazioneContenutiService.ottieniContenutoContestDaid(richiestaValidazioneDto.getIdContenuto());
        Utente utente = utenteService.ottieniUtenteById(richiestaValidazioneDto.getIdUtenteValidatore());
        List<Integer> idContestCreati = utente.getContestCreati()
                .stream()
                .map(Contest::getId)
                .collect(Collectors.toList());
        List<String> nomi = utente.getRuoli()
                .stream()
                .map(Ruolo::getNome)
                .collect(Collectors.toList());
        if(nomi.contains(RuoliUtente.ANIMATORE.name())
        && contenutoContest.isPending()==true
        && idContestCreati.contains(contenutoContest.getContestAssociato().getId())
        ){
            utenteService.aggiornaListaContenutiContest(richiestaValidazioneDto.getIdContenuto(), richiestaValidazioneDto.isValidato());
            contestService.aggiornaListaContenutoContest(richiestaValidazioneDto.getIdContenuto(), richiestaValidazioneDto.isValidato());
            contenutoContestService.validaContenutoContest(richiestaValidazioneDto.getIdContenuto(), richiestaValidazioneDto.isValidato());
        }
        else if(!nomi.contains(RuoliUtente.ANIMATORE.name())){
            throw new RichiestaValidUtenteNotValidException();
        }
        else if(!utente.getComuneAssociato().getId().equals(contenutoContest.getContestAssociato().getComuneAssociato().getId())){
            throw new RichiestaValidComuneNotValidException();
        }
        else if(!contenutoContest.isPending()){
            throw new RichiestaValidContenutoNotValidException();
        }
    }

}
