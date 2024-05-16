package it.unicam.cs.model.DTO.mappers;

import it.unicam.cs.model.DTO.output.PoiOutpuDto;
import it.unicam.cs.model.abstractions.POI;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PoiDtoMapper implements Function<POI, PoiOutpuDto> {
    @Override
    public PoiOutpuDto apply(POI poi) {
        return new PoiOutpuDto(
                poi.getId(),
                poi.getNome(),
                poi.getComuneAssociato().getNome(),
                poi.getTipoPOI().name(),
                poi.getPosizione(),
                poi.getContributore().getId()
        );
    }
}
