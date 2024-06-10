package it.unicam.cs.model.DTO.mappers;

import it.unicam.cs.model.Contest;
import it.unicam.cs.model.DTO.output.ContestOutputDto;
import it.unicam.cs.util.enums.TipoInvito;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ContestDtoMapper implements Function<Contest, ContestOutputDto> {
    @Override
    public ContestOutputDto apply(Contest contest) {
        String nPartecipanti;
        String vincitore;
        String contenutoVincitore;
        if(contest.getTipoInvito() == TipoInvito.PUBBLICO){
            nPartecipanti = "non c'è un limite di partecipanti";
        }
        else {
            nPartecipanti = String.valueOf(contest.getPartecipanti());
        }
        if(contest.getVincitore() == null && contest.getContenutoVincitore() == null){
            vincitore = "non è ancora stato assegnato un vincitore";
            contenutoVincitore = "non è ancora stato assegnato un contenuto vincitore";
        }
        else {
            vincitore = contest.getVincitore().getNome() + " " +contest.getVincitore().getCognome()+ ",\n" +contest.getVincitore().getUsername();
            contenutoVincitore =  contest.getContenutoVincitore().getNome();
        }
        return new ContestOutputDto(
                contest.getId(),
                contest.getDescrizione(),
                contest.getDataInizio(),
                contest.getDataFine(),
                contest.isAttivo(),
                contest.getOrganizzatore().getId(),
                nPartecipanti,
                contest.getPoiAssociato().getNome(),
                contest.getTipoInvito(),
                vincitore,
                contenutoVincitore
        );
    }
}
