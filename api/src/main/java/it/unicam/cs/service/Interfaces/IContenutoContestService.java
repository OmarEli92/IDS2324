package it.unicam.cs.service.Interfaces;

import it.unicam.cs.model.contenuti.ContenutoContest;

public interface IContenutoContestService {
    public void aggiungiContenutoContest(ContenutoContest contenutoContest);
    public void validaContenutoContest(Integer idContenutoContest, boolean validato);
}
