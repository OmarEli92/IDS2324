package it.unicam.cs.Mediators;

import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.service.POIService;
import it.unicam.cs.service.SalvataggioContenutiService;
import it.unicam.cs.service.UtenteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
public class EventoMediator {
    private UtenteService utenteService;
    private POIService poiService;
    private SalvataggioContenutiService salvataggioContenutiService;

    public void salvaEvento(Evento evento){
        salvataggioContenutiService.salvaEvento(evento);
        poiService.salvaEvento(evento.getPoiAssociato().getId(),evento);
        utenteService.aggiungiEvento(evento.getContributore().getId(),evento);
    }
}
