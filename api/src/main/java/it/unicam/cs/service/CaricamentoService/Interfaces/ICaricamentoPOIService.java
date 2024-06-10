package it.unicam.cs.service.CaricamentoService.Interfaces;

import it.unicam.cs.model.DTO.input.PoiDto;

public interface ICaricamentoPOIService {
    public void caricaPOI(PoiDto poiDto, Integer id);
}
