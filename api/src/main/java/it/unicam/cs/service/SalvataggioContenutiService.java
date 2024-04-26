package it.unicam.cs.service;

import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.repository.IContenutoMultimedialeRepository;
import it.unicam.cs.repository.IEventoRepository;
import it.unicam.cs.repository.IItinerarioRepository;
import it.unicam.cs.repository.IPOIRepository;
import it.unicam.cs.util.VerificaSomiglianzaContenuti;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class SalvataggioContenutiService {
    private IPOIRepository poiRepository;
    private IItinerarioRepository itinerarioRepository;
    private IContenutoMultimedialeRepository contenutoMultimedialeRepository;
    private IEventoRepository eventoRepository;
    private VerificaSomiglianzaContenuti verificaSomiglianzaContenuti;

    public void salvaPOI(POI poi){
        if(!verificaSomiglianzaContenuti.verificaSomiglianzaPOI(poi, poiRepository.findAll())){
            poiRepository.save(poi);
        }
        else {
            throw new IllegalArgumentException("poi già esistente");
        }
    }
    public void salvaItinerario(Itinerario itinerario){
        if(!verificaSomiglianzaContenuti.verificaSomiglianzaItinerario(itinerario,itinerarioRepository.findAll())){
            itinerarioRepository.save(itinerario);
        }
        else{
            throw new IllegalArgumentException("itinerario già esistente");
        }
    }
    public void salvaContenutoMultimediale(ContenutoMultimediale contenutoMultimediale){
        if(!verificaSomiglianzaContenuti.verificaSomiglianzaContenutoMultimediale(contenutoMultimediale, contenutoMultimedialeRepository.findAll())){
            contenutoMultimedialeRepository.save(contenutoMultimediale);
        }
        else{
            throw new IllegalArgumentException("itinerario già esistente");
        }
    }
    public void salvaEvento(Evento evento){
        if(!verificaSomiglianzaContenuti.verificaSomiglianzaEvento(evento,eventoRepository.findAll())){
            eventoRepository.save(evento);
        }
    }
}
