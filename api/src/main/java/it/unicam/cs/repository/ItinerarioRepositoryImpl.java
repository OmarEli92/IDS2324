package it.unicam.cs.repository;


import it.unicam.cs.model.*;
import it.unicam.cs.repository.Interfaces.IItinerarioRepository;

import java.util.Map;
import java.util.stream.Collectors;

public class ItinerarioRepositoryImpl implements IItinerarioRepository {
    private final Map<Integer, Itinerario> itinerari;

    public ItinerarioRepositoryImpl(Map<Integer, Itinerario> itinerari,Comune comune) {
        this.itinerari=itinerari;
    }

    public Map<Integer, Itinerario> ottieniItinerari(int idComune) {
        return itinerari.values()
                .stream()
                .filter(itinerario -> itinerario.getComuneAssociato().getID() == idComune)
                .collect(Collectors.toMap(Itinerario::getId, itinerario -> itinerario));

    }


    public Itinerario ottieniItinerarioDaID(int idItinerario) {
        return itinerari.get(idItinerario);
    }

    @Override
    public void aggiungiItinerario(Itinerario itinerario) {

    }

    @Override
    public void aggiungiItinerarioInPending(Itinerario itinerario) {

    }

    public void rimuoviItinerarioInPending(Itinerario itinerario) {
    }
}
