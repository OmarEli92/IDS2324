package it.unicam.cs.Mediators;

import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidComuneNotValidException;
import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidContenutoNotValidException;
import it.unicam.cs.exception.RichiestaValidazione.RichiestaValidUtenteNotValidException;
import it.unicam.cs.model.DTO.input.RichiestaValidazioneDto;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.contenuti.ContenutoContest;
import it.unicam.cs.service.*;
import it.unicam.cs.util.enums.RuoliUtente;
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
    private SalvataggioContenutiService salvataggioContenutiService;
    private ContenutoContestService contenutoContestService;
    private ConsultazioneContenutiService consultazioneContenutiService;

    public void salvaContenutoContest(ContenutoContest contenutoContest){
        contestService.aggiungiContenutoContest(contenutoContest.getContestAssociato().getId(), contenutoContest);
        utenteService.aggiungiContenutoContest(contenutoContest.getUtenteCreatore().getId(),contenutoContest);
        salvataggioContenutiService.salvaContenutoContest(contenutoContest);
    }
    public void validaContenutoContest(RichiestaValidazioneDto richiestaValidazioneDto){
        ContenutoContest contenutoContest = consultazioneContenutiService.ottieniContenutoContestDaid(richiestaValidazioneDto.getIdContenuto());
        Utente utente = utenteService.ottieniUtenteById(richiestaValidazioneDto.getIdUtenteValidatore());
        List<String> nomi = utente.getRuoli()
                .stream()
                .map(Ruolo::getNome)
                .collect(Collectors.toList());
        if(contenutoContest==null){
            throw new NullPointerException("il contenuto del contest da validare non esiste");
        }
        if(nomi.contains(RuoliUtente.ANIMATORE.name())
        && contenutoContest.isPending()==true
        && utenteService.ottieniUtenteById(richiestaValidazioneDto.getIdUtenteValidatore()).getComuneAssociato().getId().equals(consultazioneContenutiService.ottieniContenutoContestDaid(richiestaValidazioneDto.getIdContenuto()).getContestAssociato().getComuneAssociato().getId())){
            contenutoContestService.validaContenutoContest(richiestaValidazioneDto.getIdContenuto(), richiestaValidazioneDto.isValidato());
            utenteService.aggiornaListaContenutiContest(richiestaValidazioneDto.getIdContenuto(), richiestaValidazioneDto.isValidato());
            contestService.aggiornaListaContenutoContest(richiestaValidazioneDto.getIdContenuto(), richiestaValidazioneDto.isValidato());
        }
        else if(!nomi.contains(RuoliUtente.ANIMATORE.name())){
            throw new RichiestaValidUtenteNotValidException();
        }
        else if(!utente.getComuneAssociato().getId().equals(contenutoContest.getContestAssociato().getComuneAssociato().getId())){
            throw new RichiestaValidComuneNotValidException();
        }
        else{
            throw new RichiestaValidContenutoNotValidException();
        }
    }

}
