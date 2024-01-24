package RepositoryTest;

import it.unicam.cs.controller.ControllerConsultazioneContenuti;
import it.unicam.cs.model.*;
import it.unicam.cs.repository.*;
import it.unicam.cs.service.ConsultazioneContenutiService;
import it.unicam.cs.service.abstractions.IConsultazioneContenutiService;
import it.unicam.cs.util.Posizione;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ControllerConsultazioneContenutiTest {

    POITuristico poi1 = new POITuristico(1, "POI 1", new Posizione(42.345, 12.456), "Descrizione POI 1", LocalDateTime.now(), Arrays.asList(new ContenutoMultimediale[0]), 1, 1);
    POITuristico poi2 = new POITuristico(2, "POI 2", new Posizione(43.345, 13.456), "Descrizione POI 2", LocalDateTime.now(), Arrays.asList(new ContenutoMultimediale[0]), 2, 2);
    POITuristico poi3 = new POITuristico(3, "POI 3", new Posizione(44.345, 14.456), "Descrizione POI 3", LocalDateTime.now(), Arrays.asList(new ContenutoMultimediale[0]), 3, 3);

    LocalDateTime dataInizio = LocalDateTime.of(2024,01,26,0,0);
    LocalDateTime dataFine = LocalDateTime.of(2024,01,30,0,0);
    EventoTuristico evento1 = new EventoTuristico(1, "Evento 1","Evento clamoroso",dataInizio,dataFine, new Posizione(42.345, 12.456), 10,2,null,1);
    EventoTuristico evento2 = new EventoTuristico(2, "Evento 2", "Evento scandaloso",dataInizio,dataFine, new Posizione(31.345, 122.456), 10,3,null,1);
    EventoTuristico evento3 = new EventoTuristico(3, "Evento 3","Evento definitivo",dataInizio,dataFine, new Posizione(42.345, 12.456), 10,1,null,1);

    Itinerario itinerario1 = new Itinerario(1, "Itinerario 1", "Descrizione Itinerario 1", Arrays.asList(poi1, poi2), LocalDateTime.now(),null,10,1);
    Itinerario itinerario2 = new Itinerario(2, "Itinerario 2", "Descrizione Itinerario 2", Arrays.asList(poi2, poi3), LocalDateTime.now(),null,10,1);
    Itinerario itinerario3 = new Itinerario(3, "Itinerario 3", "Descrizione Itinerario 3", Arrays.asList(poi1, poi3), LocalDateTime.now(),null,10,1);

    Map<Integer, POI> pois = Map.of(
            poi1.getID(),poi1,
            poi2.getID(),poi2,
            poi3.getID(),poi3
    );

    Map<Integer, Evento> eventi = Map.of(
            evento1.getID(),evento1,
            evento2.getID(),evento2,
            evento3.getID(),evento3
    );

    Map<Integer, Itinerario> itinerari = Map.of(
            itinerario1.getID(),itinerario1,
            itinerario2.getID(),itinerario2,
            itinerario3.getID(),itinerario3
    );

    Comune comune = new Comune("SBT",1, pois,itinerari,eventi,null,null,null,null,1);
    ListaComuni listaComuni = new ListaComuni(List.of(comune),null);
    POIRepository poiRepository = new POIRepositoryImpl(pois);
    EventoRepository eventoRepository = new EventoRepositoryImpl(eventi);
    ItinerarioRepository itinerarioRepository = new ItinerarioRepositoryImpl(itinerari);
    IConsultazioneContenutiService consultazioneContenutiService = new ConsultazioneContenutiService(poiRepository, itinerarioRepository, eventoRepository);
    ControllerConsultazioneContenuti controllerConsultazioneContenuti = new ControllerConsultazioneContenuti(consultazioneContenutiService, listaComuni);

    @Test
    void visualizzaPOI() {
        controllerConsultazioneContenuti.selezionaComune(comune.getNome());
        controllerConsultazioneContenuti.visualizzaPOI(1);
        controllerConsultazioneContenuti.visualizzaPOI(2);
        controllerConsultazioneContenuti.visualizzaPOI(3);
        assertThrows(NullPointerException.class,() -> controllerConsultazioneContenuti.visualizzaPOI(40));
    }

    @Test
    void visualizzaPOIS() {
        controllerConsultazioneContenuti.selezionaComune(comune.getNome());
        controllerConsultazioneContenuti.visualizzaPOIS();
    }

    @Test
    void visualizzaEvento() {
        controllerConsultazioneContenuti.selezionaComune(comune.getNome());
        controllerConsultazioneContenuti.visualizzaEvento(1);
        controllerConsultazioneContenuti.visualizzaEvento(2);
        controllerConsultazioneContenuti.visualizzaEvento(3);

        assertThrows(NullPointerException.class,() -> controllerConsultazioneContenuti.visualizzaEvento(30));
    }

    @Test
    void visualizzaEventi() {
        controllerConsultazioneContenuti.selezionaComune(comune.getNome());
        controllerConsultazioneContenuti.visualizzaEventi();
    }

    @Test
    void visualizzaItinerario() {
        controllerConsultazioneContenuti.selezionaComune(comune.getNome());
        controllerConsultazioneContenuti.visualizzaItinerario(1);
        controllerConsultazioneContenuti.visualizzaItinerario(2);
        controllerConsultazioneContenuti.visualizzaItinerario(3);
        assertThrows(NullPointerException.class,() -> controllerConsultazioneContenuti.visualizzaItinerario(20));

    }

    @Test
    void visualizzaItinerari() {
        controllerConsultazioneContenuti.selezionaComune(comune.getNome());
        controllerConsultazioneContenuti.visualizzaItinerari();
    }
}