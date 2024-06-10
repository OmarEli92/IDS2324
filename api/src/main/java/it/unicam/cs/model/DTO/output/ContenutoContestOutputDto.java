package it.unicam.cs.model.DTO.output;

import it.unicam.cs.util.enums.TipoContenuto;

public record ContenutoContestOutputDto(
        Integer id,
        String nome,
        TipoContenuto tipoContenuto,
        Integer creatore,
        String contestAssociato
) {
}
