package it.unicam.cs.repository;


import it.unicam.cs.exception.ItinerarioNotFoundException;
import it.unicam.cs.model.Itinerario;
import java.util.Map;
import java.util.stream.Collectors;

public class ItinerarioRepositoryImpl implements ItinerarioRepository{
    private final Map<Integer, Itinerario> itinerari;

    public ItinerarioRepositoryImpl(Map<Integer, Itinerario> itinerari){
        this.itinerari = itinerari;
    }

    @Override
    public Map<Integer, Itinerario> ottieniItinerari(int idComune) {
        return itinerari.values()
                .stream()
                .filter(itinerario -> itinerario.getIdComune() == idComune)
                .collect(Collectors.toMap(Itinerario::getID, itinerario -> itinerario));

    }

    @Override
    public Itinerario ottieniItinerarioDaID(int idItinerario){
        return itinerari.get(idItinerario);

    }
}
