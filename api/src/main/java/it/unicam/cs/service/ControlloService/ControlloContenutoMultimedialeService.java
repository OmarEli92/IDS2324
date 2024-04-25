package it.unicam.cs.service.ControlloService;

import it.unicam.cs.exception.Contenuto.EventoNotValidException;
import it.unicam.cs.exception.Contenuto.FotoNotValidExcetion;
import it.unicam.cs.exception.Contenuto.LinkNotValidException;
import it.unicam.cs.exception.Contenuto.POINotValidException;
import it.unicam.cs.exception.UtentePOINotValidException;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.DTO.ContenutoMultimedialeDto;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.repository.IEventoRepository;
import it.unicam.cs.repository.IPOIRepository;
import it.unicam.cs.repository.UtenteRepository;
import it.unicam.cs.util.enums.RuoliUtente;
import it.unicam.cs.util.enums.TipoContenuto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.regex.Pattern;

public class ControlloContenutoMultimedialeService {
    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private IPOIRepository poiRepository;
    @Autowired
    private IEventoRepository eventoRepository;

    public void verificaContenutoMultimediale(ContenutoMultimedialeDto contenutoMultimedialeDto){
        Optional<POI> poi = poiRepository.findById(contenutoMultimedialeDto.getIdPoi());
        Optional<Evento> evento = eventoRepository.findById(contenutoMultimedialeDto.getIdEvento());
        Utente utente = utenteRepository.findUtenteById(contenutoMultimedialeDto.getIdContributore());
        verificaIdContributore(utente);
        verificaTipoContenuto(contenutoMultimedialeDto);
        verificaIdPoi(poi, utente);
        verificaIdEvento(evento,poi);

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


    private void verificaIdEvento(Optional<Evento> evento, Optional<POI> poi) {
        if(!evento.isPresent()){
            throw new NullPointerException("evento non esistente");
        }
        if(!poi.get().getEventiAssociati().contains(evento)){
            throw new EventoNotValidException();
        }
    }

    private void verificaIdPoi(Optional<POI> poi, Utente utente) {
        if(!poi.isPresent()){
            throw new NullPointerException("poi non esistente");
        }
        Comune comunePOI = poi.get().getComuneAssociato();
        Comune comuneUtente = utente.getComuneAssociato();
        if(comunePOI.getId() != comuneUtente.getId()){
            throw new POINotValidException();
        }
    }

    private void verificaIdContributore(Utente utente) {
        if(!utente.getRuoli().contains(RuoliUtente.CONTRIBUTORE)
                && !utente.getRuoli().contains(RuoliUtente.CONTRIBUTORE_AUTORIZZATO)
                && !utente.getRuoli().contains((RuoliUtente.CURATORE))){
            throw new UtentePOINotValidException("l'utente non è autorizzato a caricare il POI");
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