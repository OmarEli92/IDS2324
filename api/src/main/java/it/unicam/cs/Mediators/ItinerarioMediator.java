package it.unicam.cs.Mediators;

import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.service.ComuneService;
import it.unicam.cs.service.SalvataggioContenutiService;
import it.unicam.cs.service.UtenteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
public class ItinerarioMediator {
    private ComuneService comuneService;
    private UtenteService utenteService;
    private SalvataggioContenutiService salvataggioContenutiService;

    public void salvaItinerario(Itinerario itinerario){
        salvataggioContenutiService.salvaItinerario(itinerario);
        comuneService.aggiungiItinerario(itinerario.getComuneAssociato().getId(),itinerario);
        utenteService.aggiungiItinerario(itinerario.getComuneAssociato().getId(),itinerario);
    }
}
