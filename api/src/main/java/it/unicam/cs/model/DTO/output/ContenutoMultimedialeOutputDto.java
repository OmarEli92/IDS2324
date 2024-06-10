package it.unicam.cs.model.DTO.output;

public record ContenutoMultimedialeOutputDto(
        Integer id,
        String nome,
        Integer creatore,
        String poiAssociato,
        String eventoAssociato,
        String itinerarioAssociato,
        String comuneAssociato
) {
}
