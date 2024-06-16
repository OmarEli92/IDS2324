package it.unicam.cs.proxy;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.repository.IComuneRepository;
import it.unicam.cs.repository.IEventoRepository;
import it.unicam.cs.repository.IPOIRepository;
import it.unicam.cs.service.Interfaces.IGeolocalizzazioneService;
import it.unicam.cs.service.OSMService;
import it.unicam.cs.util.info.DettagliComune;
import it.unicam.cs.util.info.Posizione;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProxyService implements IGeolocalizzazioneService {
    private final OSMService osmService;
    private final int maxSize = 10; // grandezza mappa
    private Map<String, Comune> cache;

    public ProxyService(OSMService osmService, IComuneRepository comuneRepository){
        this.osmService = osmService;
        this.cache = new LinkedHashMap<>(maxSize, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Comune> menoRecente) {
                return size() > maxSize;
            }
        };
    }

    @Override
    public DettagliComune ottieniPosizioneComune(String comune) {
        Comune comuneTrovato = cache.get(comune);
        DettagliComune posizione = null;
        if(comuneTrovato!=null){
            posizione = comuneTrovato.getPosizione();
        }
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
    public void aggiungiComune(Comune comune){
        if(comune == null){
            throw new NullPointerException("Il comune non può essere null");
        }
        if(!cache.containsKey(comune.getNome())){
            cache.put(comune.getNome(),comune);
        }
        else {
            throw new IllegalArgumentException("Il comune è gia salvato nella cache");
        }
    }

    public void invalidaComuneNellaCache(String nomeComune) {
        if(ottieniComune(nomeComune) != null) {
            cache.remove(nomeComune);
        }
    }
    public Comune ottieniComune(String nomeComune){
        Comune comune = cache.values()
                .stream()
                .filter(comune1 -> comune1.getNome() .equals(nomeComune))
                .findAny()
                .orElse(null);
        return comune;
    }

    public Comune ottieniComuneDaId(int IdComune){
        return cache.values()
                .stream()
                .filter(comune -> comune.getId() == IdComune)
                .findAny()
                .orElse(null);
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
