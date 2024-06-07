package it.unicam.cs.util;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.POIIntrattenimento;
import it.unicam.cs.repository.*;
import it.unicam.cs.util.enums.StatoElemento;
import it.unicam.cs.util.enums.TipoIntrattenimento;
import it.unicam.cs.util.enums.TipoPOI;
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
    IRuoloRepository ruoloRepository;
    @Autowired
    public DBLoader(IPOIRepository poiRepository, IEventoRepository eventoRepository,
                    IItinerarioRepository itinerarioRepository, IComuneRepository comuneRepository,
                    UtenteRepository utenteRepository, IRuoloRepository ruoloRepository) {

        this.poiRepository = poiRepository;
        this.eventoRepository = eventoRepository;
        this.itinerarioRepository = itinerarioRepository;
        this.comuneRepository = comuneRepository;
        this.utenteRepository = utenteRepository;
        this.ruoloRepository = ruoloRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        Comune comune = new Comune("Camerino",1,"MC","Marche",new Posizione(12,
                21),new ArrayList<>(),
                null,null,null,null,null,null);
        Comune comune2 = new Comune("Grottammare",2,"MC","Marche",new Posizione(12,21), new ArrayList<>(),null,null,
                null,null,null,null);
        comuneRepository.save(comune);
        comuneRepository.save(comune2);
        Ruolo ruolo = new Ruolo("Gestore_Piattaforma".toUpperCase());
        Ruolo ruolo2 = new Ruolo("Curatore".toUpperCase());
        Ruolo ruolo3 = new Ruolo("Contributore".toUpperCase());
        Ruolo ruolo4 = new Ruolo("Gestore_Comune".toUpperCase());
        Ruolo ruolo5 = new Ruolo("Animatore".toUpperCase());
        Ruolo ruolo6 = new Ruolo("Contributore_Autorizzato".toUpperCase());
        Ruolo ruolo7 = new Ruolo("Partecipante_Contest".toUpperCase());
        ruoloRepository.save(ruolo);
        ruoloRepository.save(ruolo2);
        ruoloRepository.save(ruolo3);
        ruoloRepository.save(ruolo4);
        ruoloRepository.save(ruolo5);
        ruoloRepository.save(ruolo6);
        ruoloRepository.save(ruolo7);
        List<Ruolo> ruoli = new ArrayList<>();
        ruoli.add(ruolo);
        Utente utente = new Utente(1,"Omar92","password","Omar","El Idrissi",
                LocalDate.of(1992,11,20),
                "omarel@hotmail.com","maschio","3480032789",
                0,comune2,ruoli, new ArrayList<>(),
                new ArrayList<>(),new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(),new ArrayList<>());
        utenteRepository.save(utente);
        poiRepository.save(new POIIntrattenimento("Cinema delle palme", new Posizione(12,
                21), TipoPOI.INTRATTENIMENTO,utente, StatoElemento.PUBBLICATO, comune, null,
                null,null,TipoIntrattenimento.CINEMA,14, "16-24",
                null,null));
        List<POI> pois = new ArrayList<>();
        poiRepository.save(new POIIntrattenimento( "Cinema a Grottammare", new Posizione(12,
                21),TipoPOI.INTRATTENIMENTO, utente, StatoElemento.PUBBLICATO, comune, null,
                null,null,TipoIntrattenimento.CINEMA,14, "16-24",
                null,null));

        pois.add(poiRepository.findById(2).get());
        utenteRepository.save(utente);

    }
}
