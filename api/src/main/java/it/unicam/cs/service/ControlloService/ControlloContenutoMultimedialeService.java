package it.unicam.cs.service.ControlloService;

import it.unicam.cs.exception.Contenuto.EventoNotValidException;
import it.unicam.cs.exception.Contenuto.FotoNotValidExcetion;
import it.unicam.cs.exception.Contenuto.LinkNotValidException;
import it.unicam.cs.exception.Contenuto.POINotValidException;
import it.unicam.cs.exception.UtentePOINotValidException;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.DTO.input.ContenutoMultimedialeDto;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.repository.IEventoRepository;
import it.unicam.cs.repository.IItinerarioRepository;
import it.unicam.cs.repository.IPOIRepository;
import it.unicam.cs.repository.UtenteRepository;
import it.unicam.cs.util.enums.RuoliUtente;
import it.unicam.cs.util.enums.TipoContenuto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;
@Service
public class ControlloContenutoMultimedialeService {
    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private IPOIRepository poiRepository;
    @Autowired
    private IEventoRepository eventoRepository;
    @Autowired
    private IItinerarioRepository itinerarioRepository;

    public void verificaContenutoMultimediale(ContenutoMultimedialeDto contenutoMultimedialeDto){
        POI poi = poiRepository.getReferenceById(contenutoMultimedialeDto.getIdPoi());
        Evento evento = eventoRepository.getReferenceById(contenutoMultimedialeDto.getIdEvento());
        Utente utente = utenteRepository.findUtenteById(contenutoMultimedialeDto.getIdContributore());
        Itinerario itinerario = itinerarioRepository.getReferenceById(contenutoMultimedialeDto.getIdItinerario());
        verificaIdContributore(utente);
        verificaTipoContenuto(contenutoMultimedialeDto);
        verificaElementoComuneAssociato(poi,evento,itinerario);
        verificaIdPoi(poi, utente);
        verificaIdEvento(evento,utente);
        verificaIdItinerario(itinerario,utente);
    }

    private void verificaTipoContenuto(ContenutoMultimedialeDto contenutoMultimedialeDto) {
        if (contenutoMultimedialeDto.getTipoContenuto() == null) {
            throw new NullPointerException("il tipo del contenuto multimediale non può essere nullo");
        }
        if (contenutoMultimedialeDto.getTipoContenuto().equalsIgnoreCase(TipoContenuto.FOTO.name())) {
            controllaFoto(contenutoMultimedialeDto.getNome());
        } else if (contenutoMultimedialeDto.getTipoContenuto().equalsIgnoreCase(TipoContenuto.LINK.name())) {
            controllaLink(contenutoMultimedialeDto.getNome());
        } else if (contenutoMultimedialeDto.getTipoContenuto().equalsIgnoreCase(TipoContenuto.DIDASCALIA.name())) {
            controllaNome(contenutoMultimedialeDto.getNome());
        } else throw new IllegalArgumentException("il tipo del contenuto multimediale non esiste");
    }

    private void controllaLink(String nome) {
        if(nome == null){
            throw new NullPointerException("la stringa per il link non può esssre nulla");
        }
        Pattern pattern = Pattern.compile("^(http(s)?://)?([a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}(/[a-zA-Z0-9-_.~%]+)*(/\\?[a-zA-Z0-9-_.~&=]+)?$");
        boolean valid = pattern.matcher(nome).matches();
        if(!valid){
            throw new LinkNotValidException();
        }
    }

    private void controllaFoto(String nome) {
        if (!((nome == null) || nome.endsWith(".jpg")
                || nome.endsWith(".png") || nome.endsWith(".jpeg"))) {
            throw new FotoNotValidExcetion();
        }
    }


    private void verificaIdEvento(Evento evento, Utente utente) {
        if(evento!=null){
            Comune comuneEvento = evento.getComuneAssociato();
            Comune comuneUtente = utente.getComuneAssociato();
            if(comuneEvento.getId()!=comuneUtente.getId()){
                throw new EventoNotValidException();
            }
        }
    }

    private void verificaIdPoi(POI poi, Utente utente) {
        if(poi!=null) {
            Comune comunePOI = poi.getComuneAssociato();
            Comune comuneUtente = utente.getComuneAssociato();
            if (comunePOI.getId() != comuneUtente.getId()) {
                throw new POINotValidException();
            }
        }
    }
    private void verificaIdItinerario(Itinerario itinerario, Utente utente) {
        if(itinerario!=null){
            Comune comuneItinerario = itinerario.getComuneAssociato();
            Comune comuneUtente = utente.getComuneAssociato();
            if(comuneItinerario.getId() != comuneUtente.getId()){
                throw new IllegalArgumentException("comune dell'itinerario diverso dal comune " +
                        "dell'utente");
            }
        }
    }

    private void verificaIdContributore(Utente utente) {
        if(!utente.getRuoli().contains(RuoliUtente.CONTRIBUTORE)
                && !utente.getRuoli().contains(RuoliUtente.CONTRIBUTORE_AUTORIZZATO)
                && !utente.getRuoli().contains((RuoliUtente.CURATORE))){
            throw new UtentePOINotValidException("l'utente non è autorizzato a caricare il POI");
        }
    }
    private void verificaElementoComuneAssociato(POI poi, Evento evento, Itinerario itinerario) {
        if (poi == null && evento == null && itinerario == null) {
            throw new IllegalArgumentException("l'elemento del comune deve essere settato");
        } else if ((poi != null && evento != null && itinerario != null) ||
                (poi != null && evento != null) || (evento != null && itinerario != null) ||
                (poi != null && itinerario != null)) {
            throw new IllegalArgumentException("ci deve essere un solo elemento del comune settato");
        }
    }

    private void controllaNome(String nome) {
            if(nome.isBlank()){
                throw new IllegalArgumentException("il nome non può essere nullo, vuoto e non può " +
                        "contenere solo spazi bianchi ");
            }
            if (nome.trim().length()<3 && nome.trim().length()>20){
                throw new IllegalArgumentException("lunghezza nome incorretta");
            }
    }
}
