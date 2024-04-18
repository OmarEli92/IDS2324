package it.unicam.cs.util;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.POIIntrattenimento;
import it.unicam.cs.repository.*;
import it.unicam.cs.util.enums.StatoElemento;
import it.unicam.cs.util.enums.TipoIntrattenimento;
import it.unicam.cs.util.info.Posizione;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DBLoader implements CommandLineRunner {
    IPOIRepository poiRepository;
    IEventoRepository eventoRepository;
    IItinerarioRepository itinerarioRepository;
    IComuneRepository comuneRepository;
    UtenteRepository utenteRepository;
    @Autowired
    public DBLoader(IPOIRepository poiRepository, IEventoRepository eventoRepository,
                    IItinerarioRepository itinerarioRepository, IComuneRepository comuneRepository,
                    UtenteRepository utenteRepository) {

        this.poiRepository = poiRepository;
        this.eventoRepository = eventoRepository;
        this.itinerarioRepository = itinerarioRepository;
        this.comuneRepository = comuneRepository;
        this.utenteRepository = utenteRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        Comune comune = new Comune("Camerino",1,"MC","Marche",new Posizione(12,
                21),new ArrayList<>(),
                null,null,null,null,null);
        Comune comune2 = new Comune("Grottammare",2,"MC","Marche",new Posizione(12,
                21),new ArrayList<>(),null,null,
                null,null,null);
        comuneRepository.save(comune);
        comuneRepository.save(comune2);
        poiRepository.save(new POIIntrattenimento(1, "Cinema delle palme", new Posizione(12,
                21), null, StatoElemento.PUBBLICATO, null, null,
                null,null,TipoIntrattenimento.CINEMA,14, "16-24",
                null,null));
        List<POI> pois = new ArrayList<>();
        poiRepository.save(new POIIntrattenimento(4, "Cinema a Grottammare", new Posizione(12,
                21), null, StatoElemento.PUBBLICATO, null, null,
                null,null,TipoIntrattenimento.CINEMA,14, "16-24",
                null,null));

        pois.add(poiRepository.findById(2).get());
        utenteRepository.save(
                new Utente(1,"Omar92","password","Omar","El Idrissi",
                        LocalDate.of(1992,11,20),
                        "omarel@hotmail.com","maschio","1234567890",
                        0,comune2,new ArrayList<>(), new ArrayList<>(),
                        new ArrayList<>(),new ArrayList<>())
        );



    }
}
