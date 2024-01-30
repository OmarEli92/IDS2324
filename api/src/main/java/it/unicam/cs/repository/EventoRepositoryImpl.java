package it.unicam.cs.repository;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Contenuto;
import it.unicam.cs.model.Curatore;
import it.unicam.cs.model.Evento;
import it.unicam.cs.repository.Abstractions.AbstractContenutoRepository;

import java.util.Map;
import java.util.stream.Collectors;

/** Implementazione pre-SpringBoot della respository per gli eventi**/
public class EventoRepositoryImpl extends AbstractContenutoRepository {
    private final Map<Integer, Evento> eventi;

    public EventoRepositoryImpl(Map<Integer, Evento> eventi,Comune comune){
        super(comune);
        this.eventi=eventi;
    }


    public Map<Integer, Evento> ottieniEventi(int idComune) {
        return eventi.values()
                .stream()
                .filter(evento -> evento.getIdComune() == idComune)
                .collect(Collectors.toMap(Evento::getID, evento -> evento));
    }


    public Evento ottieniEventoDaID(int idEvento) {
        return eventi.get(idEvento);
    }
    @Override
    public void aggiungiContenuto(Contenuto evento) {
    super.comune.aggiungiEvento((Evento) evento);
    }

    @Override
    public void aggiungiContenutoInPending(Contenuto evento) {
    this.comune.aggiungiEventoInPending((Evento) evento);
    }

    @Override
    public void rimuoviContenutoInPending(Contenuto evento) {
    this.comune.rimuoviEventoInPending((Evento) evento);
    }
}
