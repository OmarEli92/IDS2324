package it.unicam.cs.model.DTO.output;

public record ItinerarioOutputDto(
        Integer id,
        String nome,
        String descrizione,
        Integer contributore,
        String comuneAssociato,
        String poisAssociati
) {
}
