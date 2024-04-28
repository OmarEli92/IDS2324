package it.unicam.cs.Mediators;

import it.unicam.cs.model.Utente;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.repository.IEventoRepository;
import it.unicam.cs.repository.IItinerarioRepository;
import it.unicam.cs.repository.IPOIRepository;
import it.unicam.cs.repository.UtenteRepository;
import it.unicam.cs.service.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
public class ContenutoMultimedialeMediator {
    private UtenteService utenteService;
    private EventoService eventoService;
    private POIService poiService;
    private ItinerarioService itinerarioService;
    private SalvataggioContenutiService salvataggioContenutiService;

    public void salvaContenutoMultimediale(ContenutoMultimediale contenutoMultimediale){
        salvataggioContenutiService.salvaContenutoMultimediale(contenutoMultimediale);
        if(contenutoMultimediale.getEventoAssociato()!=null){
            eventoService.salvaContenutoMultimediale(contenutoMultimediale.getEventoAssociato().getId(),contenutoMultimediale);
        }
        else if(contenutoMultimediale.getPoiAssociato()!=null){
            poiService.salvaContenutoMultimediale(contenutoMultimediale.getPoiAssociato().getId(),contenutoMultimediale);
        }
        else{
            itinerarioService.salvaContenutoMultimediale(contenutoMultimediale, contenutoMultimediale.getItinerarioAssociato().getId());
        }
        utenteService.aggiungiContenutoMultimediale(contenutoMultimediale.getUtenteCreatore().getId(),contenutoMultimediale);
    }
}
