package it.unicam.cs.service.ControlloService;

import it.unicam.cs.exception.Contenuto.POINotValidException;
import it.unicam.cs.exception.Contest.TipoInvitoException;
import it.unicam.cs.model.DTO.input.ContestDto;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.service.ConsultazioneContenutiService;
import it.unicam.cs.service.UtenteService;
import it.unicam.cs.util.enums.RuoliUtente;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ControlloContestService {
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private ConsultazioneContenutiService consultazioneContenutiService;

    public void verificaContest(ContestDto contestDto){
        verificaDescrizione(contestDto.getDescrizione());
        verificaDateContest(contestDto.getDataInizio(),contestDto.getDataFine());
        verificaTipoInvito(contestDto.getTipoInvito());
        verificaNumeroPartecipanti(contestDto);
    }

    private void verificaTipoInvito(String tipoInvito) {
        if(tipoInvito == null){
            throw new NullPointerException("la stringa tipoInvito non può essere nulla");
        }
        if(!tipoInvito.equalsIgnoreCase("invito") && !tipoInvito.equalsIgnoreCase("pubblico")){
            throw new TipoInvitoException();
        }
    }

    private void verificaNumeroPartecipanti(ContestDto contestDto) {
        if(contestDto.getTipoInvito().equalsIgnoreCase("invito")) {
            if (contestDto.getPartecipanti() < 2) {
                throw new IllegalArgumentException("il contest deve avere almeno un partecipante");
            }
        }
    }

    private void verificaDateContest(LocalDate dataInizio, LocalDate dataFine) {
        if(LocalDate.now().isAfter(dataInizio) || LocalDate.now().isAfter(dataFine) ||
                dataFine.isBefore(dataInizio)){
            throw new IllegalArgumentException("le date di inizio e fine non possono essere " +
                    "prima di quella di oggi, e la data di inizio deve anticipare la data di fine");
        }
    }

    private void verificaDescrizione(String descrizione) {
        if(descrizione==null){
            throw new NullPointerException("la descrizione del contest non può essere nulla");
        }
        if(descrizione.isBlank() || descrizione.trim().length()<20){
            throw new IllegalArgumentException("la descrizione del contest deve avere almeno 20 caratteri");
        }
    }
}
