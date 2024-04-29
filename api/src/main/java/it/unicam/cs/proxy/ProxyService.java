package it.unicam.cs.proxy;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.service.Interfaces.IGeolocalizzazioneService;
import it.unicam.cs.service.OSMService;
import it.unicam.cs.util.info.Posizione;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProxyService implements IGeolocalizzazioneService {
    private final OSMService osmService;
    private final Cache<String, Comune> cache = new LRUCache(5);

    public ProxyService(OSMService osmService){
        this.osmService = osmService;

    }

    @Override
    public Posizione ottieniPosizioneComune(String comune) {
        Posizione posizione = cache.get(comune).getPosizione();
        if(posizione == null){
            posizione = osmService.ottieniPosizioneComune(comune);
        }
        return posizione;
    }


    @Override
    public boolean verificaPuntoNelComune(Posizione posizionePunto, Posizione[] posizioneComune) {
        return osmService.verificaPuntoNelComune(posizionePunto,posizioneComune);
    }

    @Override
    public List<Posizione> ottieniPerimetro(String comune) {
        return osmService.ottieniPerimetro(comune);
    }

    public Comune ottieniComune(String nomeComune){
        Comune comune = cache.get(nomeComune);
        return comune;
    }

    public List<POI> ottieniPOI(String nomeComune){
        List<POI> pois = new ArrayList<>();
        Comune comune = ottieniComune(nomeComune);
        if(comune != null){
            comune.getPOIS()
                    .stream()
                    .map(poi -> pois.add(poi));
        }
        return pois;
    }
    public List<Evento> ottieniEventi(String nomeComune){
        List<Evento> eventi = new ArrayList<>();
        Comune comune = ottieniComune(nomeComune);
        if(comune != null){
            comune.getEventi()
                    .stream()
                    .map(evento -> eventi.add(evento));
        }
        return eventi;
    }
    public List<Itinerario> ottieniItinerari(String nomeComune){
        List<Itinerario> itinerari = new ArrayList<>();
        Comune comune = ottieniComune(nomeComune);
        if(comune != null){
            comune.getItinerari()
                    .stream()
                    .map(itinerario -> itinerari.add(itinerario));
        }
        return itinerari;
    }

}
