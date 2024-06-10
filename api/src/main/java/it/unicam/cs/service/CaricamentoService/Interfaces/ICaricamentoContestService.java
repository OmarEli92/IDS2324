package it.unicam.cs.service.CaricamentoService.Interfaces;

import it.unicam.cs.model.DTO.input.ContestDto;

public interface ICaricamentoContestService {
    public void caricaContest(ContestDto contestDto, Integer id);
}
