package it.unicam.cs.repository;

import it.unicam.cs.model.Itinerario;

import java.util.Map;

public class ItinerarioRepositoryImpl implements ItinerarioRepository {
    @Override
    public Map<Integer, Itinerario> ottieniItinerari() {
        return null;
    }

    @Override
    public Itinerario ottieniItinerarioDaID(int idItinerario) {
        return null;
    }

    @Override
    public void aggiungiItinerario(Itinerario itinerario) {
        itinerario.getComuneAssociato().getItinerari().add(itinerario);
    }

    @Override
    public void aggiungiItinerrarioInPending(Itinerario itinerario) {
        itinerario.getComuneAssociato().getItinerariInPending().add(itinerario);
    }
}
