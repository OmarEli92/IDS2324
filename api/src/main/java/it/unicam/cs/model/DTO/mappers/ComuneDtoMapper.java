package it.unicam.cs.model.DTO.mappers;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.DTO.output.ComuneOutputDto;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ComuneDtoMapper implements Function<Comune, ComuneOutputDto> {
    @Override
    public ComuneOutputDto apply(Comune comune) {
        return new ComuneOutputDto(
                comune.getId(),
                comune.getNome()
        );
    }
}
