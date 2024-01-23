package RepositoryTest;
import it.unicam.cs.exception.EventoNotFoundException;
import it.unicam.cs.model.Evento;
import it.unicam.cs.model.EventoTuristico;
import it.unicam.cs.repository.EventoRepositoryImpl;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TestContenutiRepository {

    Map<Integer, Evento> eventi = new HashMap<>();
    EventoRepositoryImpl eventoRepository;
    Evento evento1 = new EventoTuristico(1, "evento1", "descrizione1",
            LocalDateTime.now(), LocalDateTime.now(), 1, 1, new ArrayList<>());

    Evento evento2 = new EventoTuristico(2, "evento2", "descrizione1",
            LocalDateTime.now(), LocalDateTime.now(), 1, 2, new ArrayList<>());

    Evento evento3 = new EventoTuristico(3, "evento3", "descrizione3",
            LocalDateTime.now(), LocalDateTime.now(), 1, 3, new ArrayList<>());

    @Test
    public void getEventiTest(){
        eventi.put(1,evento1);
        eventi.put(2,evento2);
        eventi.put(3,evento3);
        eventoRepository = new EventoRepositoryImpl(eventi);
        assertEquals(eventoRepository.ottieniEventi().size(),3);
    }

    @Test
    public void getEventoByID()throws EventoNotFoundException{
        eventi.put(1,evento1);
        eventi.put(2,evento2);
        eventi.put(3,evento3);
        eventoRepository = new EventoRepositoryImpl(eventi);
        assertEquals(eventoRepository.ottieniEventoDaID(1),evento1);
        assertEquals(eventoRepository.ottieniEventoDaID(2),evento2);
        assertEquals(eventoRepository.ottieniEventoDaID(3),evento3);
        assertThrows(EventoNotFoundException.class,() -> eventoRepository.ottieniEventoDaID(10));
    }
}
