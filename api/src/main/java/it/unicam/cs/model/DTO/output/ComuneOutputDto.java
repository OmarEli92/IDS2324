package it.unicam.cs.model.DTO.output;

import it.unicam.cs.util.info.Posizione;

import java.util.List;

public record ComuneOutputDto(
        Integer id,
        String nome,
        Posizione posizione,
        List<Posizione> territorio
) {
}
