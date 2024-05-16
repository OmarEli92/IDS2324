package it.unicam.cs.model.DTO.mappers;

import it.unicam.cs.model.DTO.output.ContenutoContestOutputDto;
import it.unicam.cs.model.DTO.output.ContestOutputDto;
import it.unicam.cs.model.contenuti.ContenutoContest;
import it.unicam.cs.util.enums.TipoContenuto;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ContenutoContestDtoMapper implements Function<ContenutoContest, ContenutoContestOutputDto> {
    @Override
    public ContenutoContestOutputDto apply(ContenutoContest contenutoContest) {
        String nome;
        if(contenutoContest.getTipo() == TipoContenuto.FOTO){
            nome = "foto: " + contenutoContest.getNome();
        }
        else if(contenutoContest.getTipo() == TipoContenuto.LINK){
            nome = "link: " + contenutoContest.getNome();
        }
        else {
            nome = "didascalia: " + contenutoContest.getNome();
        }
        return new ContenutoContestOutputDto(
                contenutoContest.getId(),
                contenutoContest.getNome(),
                contenutoContest.getTipo(),
                contenutoContest.getUtenteCreatore().getId(),
                contenutoContest.getContestAssociato().getDescrizione()
        );
    }
}
