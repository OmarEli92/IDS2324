package it.unicam.cs.service.ControlloService;

import it.unicam.cs.exception.Contenuto.FotoNotValidExcetion;
import it.unicam.cs.exception.Contenuto.LinkNotValidException;
import it.unicam.cs.model.DTO.input.ContenutoMultimedialeDto;
import it.unicam.cs.service.ConsultazioneContenutiService;
import it.unicam.cs.service.UtenteService;
import it.unicam.cs.util.enums.TipoContenuto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class ControlloContenutoMultimedialeService {
    @Autowired
    private ConsultazioneContenutiService consultazioneContenutiService;
    @Autowired
    private UtenteService utenteService;

    public void verificaContenutoMultimediale(ContenutoMultimedialeDto contenutoMultimedialeDto){
        verificaTipoContenuto(contenutoMultimedialeDto);
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
