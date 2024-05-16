package it.unicam.cs.model.DTO.output;

import it.unicam.cs.util.info.Posizione;

public record PoiOutpuDto(
        Integer id,
        String nome,
        String comuneAssociato,
        String tipoPoi,
        Posizione posizione,
        Integer idContributore
) {


}
