package it.unicam.cs.util.Extensions;

import it.unicam.cs.exception.Contenuto.ItinerarioNotValidException;
import it.unicam.cs.exception.Contenuto.ListaPOINotValidException;
import it.unicam.cs.exception.UtentePOINotValidException;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.repository.IComuneRepository;
import it.unicam.cs.repository.IPOIRepository;
import it.unicam.cs.repository.UtenteRepository;
import it.unicam.cs.service.UtenteService;
import it.unicam.cs.util.enums.RuoliUtente;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ValidationItinerarioExtension {
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private IPOIRepository poiRepository;

    public void isItinerarioNomeValid(String nome)  {
        if(nome.isBlank()){
            throw new IllegalArgumentException("il nome non può essere nullo, vuoto e non può " +
                    "contenere solo spazi bianchi ");
        }
        if (nome.trim().length()<3 && nome.trim().length()>20){
            throw new IllegalArgumentException("lunghezza nome incorretta");
        }
    }
    public void isDescrizioneValid(String descrizione){
        if(descrizione!=null){
            if(descrizione.trim().length() < 3){
                throw new IllegalArgumentException("lunghezza descrizione non corretta");
            }
        }
    }
    public void areIdPOISValid (List<Integer> idPois, Integer idUtente){
        if(idPois == null){
            throw new NullPointerException("lista dei poi interessati " +
                    "non può essere nulla");
        }
        Utente utente = utenteService.ottieniUtenteById(idUtente);
        Comune comune = utente.getComuneAssociato();
        List<POI> pois = poiRepository.findAllById(idPois);
        Set<POI> setPois = new LinkedHashSet<>(pois);
        List<POI> arrayPois = new ArrayList<>(pois);
        if(!pois.equals(arrayPois)){
            throw new ListaPOINotValidException();
        }
        boolean valid = pois.stream().allMatch(value -> comuneContienePOI(comune,value));
    }

    private boolean comuneContienePOI(Comune comune, POI poi) {
        List<POI> listP = comune.getPOIS();
        if(!listP.contains(poi)){
            throw new ItinerarioNotValidException();
        }
        return true;
    }
    public void isItinerarioContributoreValid(Integer idContributore) {
        Utente utente = utenteService.ottieniUtenteById(idContributore);
        if (!utente.getRuoli().contains(RuoliUtente.CONTRIBUTORE)
                && !utente.getRuoli().contains(RuoliUtente.CONTRIBUTORE_AUTORIZZATO)
                && !utente.getRuoli().contains((RuoliUtente.CURATORE))) {
            throw new UtentePOINotValidException("l'utente non è autorizzato a caricare l'evento");
        }
    }
}
