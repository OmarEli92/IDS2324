package it.unicam.cs.util.Extensions;

import it.unicam.cs.exception.Contenuto.POINotFoundException;
import it.unicam.cs.exception.UtentePOINotValidException;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.repository.UtenteRepository;
import it.unicam.cs.util.enums.RuoliUtente;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Pattern;

@Component
public class ValidationEventoExtension {
    @Autowired
    private UtenteRepository utenteRepository;

    public void isNomeValid(String nome){
        if(nome.isBlank()){
            throw new IllegalArgumentException("il nome non può essere nullo, vuoto e non può " +
                    "contenere solo spazi bianchi ");
        }
        if (nome.trim().length()<3 && nome.trim().length()>20){
            throw new IllegalArgumentException("lunghezza nome incorretta");
        }
    }
    public void isIdEventovalid(Integer idUtente,Integer idPOI){
        if(idPOI == null){
            throw new NullPointerException("id poi non deve essere nullo");
        }
        Utente utente = utenteRepository.findUtenteById(idUtente);
        Comune comune = utente.getComuneAssociato();
        List<POI> pois = comune.getPOIS();
        for (POI poi : pois){
            if(poi.getId().equals(idPOI)){
                return;
            }
        }
        throw new POINotFoundException();
    }
    public void isEventoContributoreValid(Integer idContributore) {
        if(idContributore == null){
            throw new NullPointerException("id del contributpre non può essere nullo");
        }
        Utente utente = utenteRepository.getReferenceById(idContributore);
        if (!utente.getRuoli().contains(RuoliUtente.CONTRIBUTORE)
                && !utente.getRuoli().contains(RuoliUtente.CONTRIBUTORE_AUTORIZZATO)
                && !utente.getRuoli().contains((RuoliUtente.CURATORE))) {
            throw new UtentePOINotValidException("l'utente non è autorizzato a caricare l'evento");
        }
    }
    public void isDescrizioneValid(String descrizione){
        if(descrizione!=null){
            if(descrizione.trim().length() < 3){
                throw new IllegalArgumentException("lunghezza descrizione non corretta");
            }
        }
    }
    public void isResponsabileValido (String string){
        if(string != null) {
            if (string.trim().length() < 3 && string.trim().length() > 20) {
                throw new IllegalArgumentException("lunghezza responsabile non corretta");
            }
            Pattern pattern = Pattern.compile("[^a-zA-Z0-9]+");
            boolean valid = pattern.matcher(string).matches();
            if (!valid) {
                throw new IllegalArgumentException("responsabile non può avere caratteri speciali");
            }
        }
    }
    public void isEtaConsigliatiValida(int eta){
        if(eta < 0){
            throw new IllegalArgumentException("l'età deve essere maggiore uguale di 0");
        }
    }
    public void verificaDateEvento(LocalDateTime dataInizio, LocalDateTime dataFine) {
        if(LocalDateTime.now().isAfter(dataInizio) || LocalDateTime.now().isAfter(dataFine) ||
                dataFine.isBefore(dataInizio)){
            throw new IllegalArgumentException("le date di inizio e fine non possono essere " +
                    "prima di quella di oggi, e la data di inizio deve anticipare la data di fine");
        }
    }

}
