package it.unicam.cs.service.CaricamentoService;

import it.unicam.cs.Factory.POIBuilderFactory;
import it.unicam.cs.exception.POI.NamePOINotValidException;
import it.unicam.cs.exception.POI.TipoAmministrativoNotValidException;
import it.unicam.cs.exception.POI.UtentePOINotValidException;
import it.unicam.cs.model.DTO.PoiAmministrativoDto;
import it.unicam.cs.model.DTO.PoiDto;
import it.unicam.cs.model.Utente;
import it.unicam.cs.repository.UtenteRepository;
import it.unicam.cs.service.ControlloPOIService.ControlloPOIAmministrativoService;
import it.unicam.cs.util.enums.RuoliUtente;
import it.unicam.cs.util.enums.TipoAmministrativo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CaricamentoPOIService {
    private final UtenteRepository utenteRepository;
    private final POIBuilderFactory poiBuilderFactory;
    private final ControlloPOIAmministrativoService controlloPOIAmministrativoService;

    public void caricaPOI(PoiDto poiDto){
        verificaPOI(poiDto);
    }

    private void verificaPOI(PoiDto poiDto) {
        controlllaPOINome(poiDto.getNome());
        controllaPOIContributore(poiDto.getIDContributore());
        if(poiDto instanceof PoiAmministrativoDto){
            controlloPOIAmministrativoService.controllaPoiAmministrativo((PoiAmministrativoDto) poiDto);
        }

    }


    private void controllaPOIContributore(Integer idContributore) {
        Utente utente = utenteRepository.getReferenceById(idContributore);
        if(!utente.getRuoli().contains(RuoliUtente.CONTRIBUTORE)
        && !utente.getRuoli().contains(RuoliUtente.CONTRIBUTORE_AUTORIZZATO)
        && !utente.getRuoli().contains((RuoliUtente.CURATORE))){
            throw new UtentePOINotValidException("l'utente non è autorizzato a caricare il POI");
        }

    }

    private void controlllaPOINome(String nome)  {
        if (nome.length()<3 && nome.length()>20){
            throw new NamePOINotValidException("il nome deve avere almeno 3 caratteri e massimo 20");
        }
        if(nome.isBlank()){
            throw new NamePOINotValidException("il nome non può essere nullo");
        }

    }
}
