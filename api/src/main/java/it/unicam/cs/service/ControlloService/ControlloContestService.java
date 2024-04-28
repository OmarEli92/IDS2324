package it.unicam.cs.service.ControlloService;

import it.unicam.cs.exception.Contenuto.POINotValidException;
import it.unicam.cs.exception.Contest.TipoInvitoException;
import it.unicam.cs.model.DTO.ContestDto;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.repository.UtenteRepository;
import it.unicam.cs.service.ConsultazioneContenutiService;
import it.unicam.cs.service.UtenteService;
import it.unicam.cs.util.enums.RuoliUtente;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class ControlloContestService {
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private ConsultazioneContenutiService consultazioneContenutiService;

    public void verificaContest(ContestDto contestDto){
        verificaOrganizzatore(contestDto.getIdOrganizzatore());
        verificaDescrizione(contestDto.getDescrizione());
        verificaDateContest(contestDto.getDataInizio(),contestDto.getDataFine());
        verificaTipoInvito(contestDto.getTipoInvito());
        verificaNumeroPartecipanti(contestDto);
        verificaIdPoi(contestDto.getIdPoiAssociato(), contestDto.getIdOrganizzatore());
    }

    private void verificaIdPoi(Integer idPoiAssociato, Integer idOrganizzatore) {
        Utente organizzatore = utenteService.ottieniUtenteById(idOrganizzatore);
        POI poi = consultazioneContenutiService.ottieniPOIdaId(idPoiAssociato);
        if(organizzatore.getComuneAssociato().getId() != poi.getComuneAssociato().getId()){
            throw new POINotValidException();
        }
    }

    private void verificaOrganizzatore(Integer idOrganizzatore) {
        Utente utente = utenteService.ottieniUtenteById(idOrganizzatore);
        if(!utente.getRuoli().contains(RuoliUtente.ANIMATORE)){
            throw new TipoInvitoException();
        }
    }

    private void verificaTipoInvito(String tipoInvito) {
        if(!tipoInvito.equalsIgnoreCase("invito") || !tipoInvito.equalsIgnoreCase("pubblico")){
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

    private void verificaDateContest(Date dataInizio, Date dataFine) {
        if(LocalDate.now().isAfter(dataFine.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()) || LocalDate.now().isAfter(dataInizio.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()) ||
                dataFine.before(dataInizio)){
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
