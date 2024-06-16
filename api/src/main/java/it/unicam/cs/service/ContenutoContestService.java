package it.unicam.cs.service;

import it.unicam.cs.model.contenuti.ContenutoContest;
import it.unicam.cs.repository.*;
import it.unicam.cs.service.Interfaces.IConsultazioneContenutiService;
import it.unicam.cs.service.Interfaces.IContenutoContestService;
import it.unicam.cs.util.VerificaSomiglianzaContenuti;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class ContenutoContestService implements IContenutoContestService {
    private IContenutoContestRepository contenutoContestRepository;
    private VerificaSomiglianzaContenuti verificaSomiglianzaContenuti;
    private IConsultazioneContenutiService consultazioneContenutiService;
    @Override
    public void aggiungiContenutoContest(ContenutoContest contenutoContest){
        if(!verificaSomiglianzaContenuti.verificaSomiglianzaContenutoContest(contenutoContest, contenutoContestRepository.findAll())){
            contenutoContestRepository.save(contenutoContest);
        }
    }
    @Override
    @Transactional
    public void validaContenutoContest(Integer idContenutoContest, boolean validato){
        ContenutoContest contenutoContest = consultazioneContenutiService.ottieniContenutoContest(idContenutoContest);
        if(validato){
            contenutoContest.setPending(false);
            contenutoContestRepository.save(contenutoContest);
        }
        else {
            contenutoContestRepository.deleteById(idContenutoContest);
        }
    }
    @Override
    public ContenutoContest ottieniContenutoContestDaId(Integer idContenutoContest){
        return contenutoContestRepository.findById(idContenutoContest).orElseThrow(() -> new EntityNotFoundException("contenuto contest non trovato"));
    }

}
