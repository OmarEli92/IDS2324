package it.unicam.cs.model.DTO.mappers;

import it.unicam.cs.model.DTO.output.ItinerarioOutputDto;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.Itinerario;

import java.util.function.Function;
import java.util.stream.Collectors;

public class ItinerarioDtoMapper implements Function<Itinerario, ItinerarioOutputDto> {
    @Override
    public ItinerarioOutputDto apply(Itinerario itinerario) {
        return new ItinerarioOutputDto(
                itinerario.getId(),
                itinerario.getNome(),
                itinerario.getDescirizione(),
                itinerario.getContributore().getId(),
                itinerario.getComuneAssociato().getNome(),
                String.join(",",itinerario.getPoisAssociati()
                        .stream()
                        .map(POI::getNome)
                        .collect(Collectors.toList()))
        );
    }
}
