package it.unicam.cs.repository;


import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Itinerario;
import java.util.Map;
import java.util.stream.Collectors;

public class ItinerarioRepositoryImpl implements ItinerarioRepository {
    private final Map<Integer, Itinerario> itinerari;
    private final Comune comune;

    public ItinerarioRepositoryImpl(Map<Integer, Itinerario> itinerari, Comune comune) {
        this.itinerari = itinerari;
        this.comune = comune;
    }

    @Override
    public Map<Integer, Itinerario> ottieniItinerari(int idComune) {
        return itinerari.values()
                .stream()
                .filter(itinerario -> itinerario.getIdComune() == idComune)
                .collect(Collectors.toMap(Itinerario::getID, itinerario -> itinerario));

    }

    @Override
    public Itinerario ottieniItinerarioDaID(int idItinerario) {
        return itinerari.get(idItinerario);
    }

    @Override
    public void aggiungiItinerario(Itinerario itinerario) {
        this.comune.aggiungiItinerario(itinerario);
    }

    @Override
    public void aggiungiItinerarioInPending(Itinerario itinerario) {
        this.comune.aggiungiItinerarioInPending(itinerario);
    }
}
