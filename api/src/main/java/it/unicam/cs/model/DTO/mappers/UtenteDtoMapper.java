package it.unicam.cs.model.DTO.mappers;

import it.unicam.cs.model.DTO.output.UtenteDto;
import it.unicam.cs.model.Utente;
import it.unicam.cs.util.enums.RuoliUtente;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
public class UtenteDtoMapper implements Function<Utente, UtenteDto> {
    @Override
    public UtenteDto apply(Utente utente) {
        String comuneAssociato;
        if(utente.getRuoli().contains(RuoliUtente.GESTORE_PIATTAFORMA)){
            comuneAssociato = "il gestore della piattaforma non ha un comune associato";
        }
        else {
            comuneAssociato = utente.getComuneAssociato().getNome();
        }
        return new UtenteDto(
                utente.getId(),
                utente.getNome(),
                utente.getCognome(),
                utente.getUsername(),
                utente.getEmail(),
                "il gestore della piattaforma non ha un comune associato"
            );
        }
}
