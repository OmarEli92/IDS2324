package it.unicam.cs.service;

import it.unicam.cs.model.contenuti.ContenutoContest;
import it.unicam.cs.repository.*;

public class ContenutoContestService {
    private IContestRepository contestRepository;
    private IContenutoContestRepository contenutoContestRepository;
    private UtenteRepository utenteRepository;

    public void validaContenutoContest(Integer idContenutoContest, boolean validato){
        ContenutoContest contenutoContest = contenutoContestRepository.getReferenceById(idContenutoContest);
        if(validato){
            contenutoContest.setPending(false);
            contenutoContestRepository.save(contenutoContest);
        }
        else {
            contenutoContestRepository.deleteById(idContenutoContest);
        }
    }
}
