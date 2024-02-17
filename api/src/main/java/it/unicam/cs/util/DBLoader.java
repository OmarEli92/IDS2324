package it.unicam.cs.util;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.POIIntrattenimento;
import it.unicam.cs.repository.IEventoRepository;
import it.unicam.cs.repository.IItinerarioRepository;
import it.unicam.cs.repository.IPOIRepository;
import it.unicam.cs.util.enums.TipoIntrattenimento;
import it.unicam.cs.util.info.Posizione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class DBLoader implements CommandLineRunner {
    IPOIRepository poiRepository;
    IEventoRepository eventoRepository;
    IItinerarioRepository itinerarioRepository;
    @Autowired
    public DBLoader(IPOIRepository poiRepository, IEventoRepository eventoRepository,
                    IItinerarioRepository itinerarioRepository) {

        this.poiRepository = poiRepository;
        this.eventoRepository = eventoRepository;
        this.itinerarioRepository = itinerarioRepository;
    }
    @Override
    public void run(String... args) throws Exception {

        poiRepository.save(new POIIntrattenimento(1, "Cinema delle palme", new Posizione(12,
                21), TipoIntrattenimento.CINEMA.getDescrizione(),
                null, null, null, null,
                null,null,14, "16-24",
                null,null));
        List<POI> pois = new ArrayList<>();
        pois.add(poiRepository.findById(1).get());
        Comune comune = new Comune("Camerino",1,"MC","Marche",new Posizione(12,
                21),pois,null,null,
                null,null,null,null,null, null);
    }
}
