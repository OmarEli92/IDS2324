package it.unicam.cs.util;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.POIIntrattenimento;
import it.unicam.cs.repository.*;
import it.unicam.cs.service.Interfaces.IGestionePiattaformaService;
import it.unicam.cs.service.Interfaces.IUtenteService;
import it.unicam.cs.util.enums.RuoliUtente;
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
    IUtenteService utenteService;
    IRuoloRepository ruoloRepository;
    IGestionePiattaformaService gestionePiattaformaService;
    @Autowired
    public DBLoader(IPOIRepository poiRepository, IEventoRepository eventoRepository,
                    IItinerarioRepository itinerarioRepository, IComuneRepository comuneRepository,
                    UtenteRepository utenteRepository, IRuoloRepository ruoloRepository,
                    IUtenteService utenteService,
                    IGestionePiattaformaService gestionePiattaformaService) {

        this.poiRepository = poiRepository;
        this.eventoRepository = eventoRepository;
        this.itinerarioRepository = itinerarioRepository;
        this.comuneRepository = comuneRepository;
        this.utenteRepository = utenteRepository;
        this.ruoloRepository = ruoloRepository;
        this.utenteService = utenteService;
        this.gestionePiattaformaService = gestionePiattaformaService;
    }
    @Override
    public void run(String... args) throws Exception {
        Comune comune = new Comune("Camerino",1,"MC","Marche",new Posizione(12,
                21),new ArrayList<>(),null,null,
                null,null,null,
                null,null, null, 40000);
        Comune comune2 = new Comune("Grottammare",2,"MC","Marche",new Posizione(12,
                21),new ArrayList<>(),null,null,
                null,null,null,
                null,null, null,50000);
        gestionePiattaformaService.aggiungiComune(comune);
        gestionePiattaformaService.aggiungiComune(comune2);
        //comuneRepository.save(comune);
        //comuneRepository.save(comune2);
        poiRepository.save(new POIIntrattenimento(1, "Cinema delle palme", new Posizione(12,
                21), TipoIntrattenimento.CINEMA.getDescrizione(),
                null, comune, null, null,
                null,null,14, "16-24",
                null,null));
        List<POI> pois = new ArrayList<>();
        poiRepository.save(new POIIntrattenimento(4, "Cinema a Grottammare", new Posizione(12,
                21), TipoIntrattenimento.CINEMA.getDescrizione(),
                null, comune2, null, null,
                null,null,14, "16-24",
                null,null));
        for(RuoliUtente ruoli: RuoliUtente.values() ){
            Ruolo ruolo = new Ruolo();
            ruolo.setNome(ruoli.toString());
            ruoloRepository.save(ruolo);
        }
        pois.add(poiRepository.findById(2).get());
        utenteRepository.save(
                new Utente(1,"Omar1","password","Omar","El Idrissi",
                        LocalDate.of(1992,11,20),
                        "omar.elidrissi@hotmail.com","maschio","1234567890",
                        0,comune2,new ArrayList<>(), new ArrayList<>(),
                        new ArrayList<>(),new ArrayList<>())
        );
        utenteService.assegnaRuoloAutente("Omar1","CONTRIBUTORE");
    }



}
