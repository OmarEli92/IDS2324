package it.unicam.cs.service.CaricamentoService.Interfaces;

import it.unicam.cs.model.DTO.input.ContenutoContestDto;

public interface ICaricamentoContenutoContestService {
    public void caricaContenutoContest(ContenutoContestDto contenutoContestDto, Integer id);
}
