package it.unicam.cs.repository;


import it.unicam.cs.model.*;
import it.unicam.cs.model.Abstractions.Contenuto;
import it.unicam.cs.repository.Abstractions.AbstractContenutoRepository;

import java.util.Map;
import java.util.stream.Collectors;

public class ItinerarioRepositoryImpl extends AbstractContenutoRepository {
    private final Map<Integer, Itinerario> itinerari;

    public ItinerarioRepositoryImpl(Map<Integer, Itinerario> itinerari,Comune comune) {
        super(comune);
        this.itinerari=itinerari;
    }

    public Map<Integer, Itinerario> ottieniItinerari(int idComune) {
        return itinerari.values()
                .stream()
                .filter(itinerario -> itinerario.getIdComune() == idComune)
                .collect(Collectors.toMap(Itinerario::getID, itinerario -> itinerario));

    }


    public Itinerario ottieniItinerarioDaID(int idItinerario) {
        return itinerari.get(idItinerario);
    }

    @Override
    public void aggiungiContenuto(Contenuto itinerario) {
        this.comune.aggiungiItinerario((Itinerario) itinerario);
    }

    @Override
    public void aggiungiContenutoInPending(Contenuto itinerario) {
        this.comune.aggiungiItinerarioInPending((Itinerario) itinerario);
    }
    @Override
    public void rimuoviContenutoInPending(Contenuto itinerario){
        this.comune.rimuoviItinerartioInPending((Itinerario) itinerario);
    }

}
