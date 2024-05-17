package it.unicam.cs.service;

import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.repository.UtenteRepository;
import it.unicam.cs.service.Interfaces.IGestioneComuneService;
import it.unicam.cs.service.Interfaces.IGestioneContenutiService;

import java.util.Collection;
import java.util.Optional;

public class GestioneComuneService implements IGestioneComuneService {

    private final UtenteRepository utenteRepository;

    public GestioneComuneService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    @Override
    public Optional<Utente> ottieniCuratore(int idCuratore) {
        return utenteRepository.findById(idCuratore);
    }

    @Override
    public Collection<Utente> ottieniCuratori(int idComune) {
        return utenteRepository.findByRuoli_NomeAndComuneAssociato_Nome("Curatore",idComune);
    }

    @Override
    public void aggiungiCuratore(Utente curatore) {
        if(curatore != null)
            utenteRepository.save(curatore);
    }

    @Override
    public void rimuoviCuratore(int idCuratore) {
        utenteRepository.deleteById(idCuratore);
    }

}
