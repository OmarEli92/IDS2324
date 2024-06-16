package it.unicam.cs.model.DTO.output;

import it.unicam.cs.util.info.DettagliComune;
import it.unicam.cs.util.info.Posizione;

import java.util.List;

public record ComuneOutputDto(
        Integer id,
        String nome,
        DettagliComune posizione,
        List<Posizione> territorio
) {
}
