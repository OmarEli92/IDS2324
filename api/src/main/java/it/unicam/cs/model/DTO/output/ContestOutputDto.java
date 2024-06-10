package it.unicam.cs.model.DTO.output;

import it.unicam.cs.util.enums.TipoInvito;

import java.time.LocalDate;

public record ContestOutputDto(
        Integer id,
        String descrizione,
        LocalDate dataInizio,
        LocalDate dataFine,
        boolean attivo,
        Integer organizzatore,
        String numeroPartecipanti,
        String poiAssociato,
        TipoInvito tipoInvito,
        String vincitore,
        String contenutoVincitore
) {
}
