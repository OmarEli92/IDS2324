package it.unicam.cs.model.DTO.mappers;

import it.unicam.cs.model.DTO.output.ContenutoMultimedialeOutputDto;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.regex.Pattern;

@Component
public class ContenutoMultimedialeDtoMapper implements Function<ContenutoMultimediale, ContenutoMultimedialeOutputDto> {
    @Override
    public ContenutoMultimedialeOutputDto apply(ContenutoMultimediale contenutoMultimediale) {
        String nome;
        if(Pattern.matches("^(http(s)?://)?([a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}(/[a-zA-Z0-9-_.~%]+)*(/\\?[a-zA-Z0-9-_.~&=]+)?$",contenutoMultimediale.getNome())){
            nome = "link: " + contenutoMultimediale.getNome();
        }
        else if(contenutoMultimediale.getNome().endsWith(".jpg")
                || contenutoMultimediale.getNome().endsWith(".png") || contenutoMultimediale.getNome().endsWith(".jpeg")){
            nome = "foto: " + contenutoMultimediale.getNome();
        }
        else {
            nome = "didascalia: " + contenutoMultimediale.getNome();
        }
        String poi;
        String evento;
        String itinerario;
        if(contenutoMultimediale.getPoiAssociato() != null){
            poi = contenutoMultimediale.getPoiAssociato().getNome();
            evento = "nessun evento associato";
            itinerario = "nessun itinerario associato";
        }
        else if(contenutoMultimediale.getEventoAssociato() != null){
            poi = "nessun poi associato";
            evento = contenutoMultimediale.getEventoAssociato().getNome();
            itinerario = "nessun itinerario associato";
        }
        else {
            poi = "nessun poi associato";
            evento = "nessun evento associato";
            itinerario = contenutoMultimediale.getItinerarioAssociato().getNome();
        }
        return new ContenutoMultimedialeOutputDto(
                contenutoMultimediale.getId(),
                contenutoMultimediale.getNome(),
                contenutoMultimediale.getUtenteCreatore().getId(),
                poi,
                evento,
                itinerario,
                contenutoMultimediale.getComuneAssociato().getNome()
        );
    }
}
