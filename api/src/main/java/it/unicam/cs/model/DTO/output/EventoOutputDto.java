package it.unicam.cs.model.DTO.output;

import java.time.LocalDateTime;

public record EventoOutputDto(
        Integer id,
        String nome,
        String descrizione,
        String poiAssociato,
        String comuneAssociato,
        Integer contributore,
        LocalDateTime dataInizio,
        LocalDateTime dataFine
) {
}
