package it.unicam.cs.Mediators;

import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.service.Interfaces.IComuneService;
import it.unicam.cs.service.Interfaces.IUtenteService;
import it.unicam.cs.util.enums.RuoliUtente;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
public class UtenteMediator {
    private IComuneService comuneService;
    private IUtenteService utenteService;

    public void aggiungiUtente(Utente utente) {
        utenteService.salvaUtente(utente);
        if(!utente.getRuoli().stream()
                .map(Ruolo::getNome)
                .collect(Collectors.toList())
                .contains(RuoliUtente.GESTORE_PIATTAFORMA.name())){
            comuneService.aggiungiUtente(utente.getId(), utente.getComuneAssociato().getId());
        }
    }
}
