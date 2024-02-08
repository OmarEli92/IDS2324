package it.unicam.cs.service;

import it.unicam.cs.repository.IItinerarioRepository;

public class VerificaItinerarioService{
    IItinerarioRepository itinerarioRepository;
    public VerificaItinerarioService(IItinerarioRepository itinerarioRepository) {
        this.itinerarioRepository = itinerarioRepository;
    }
}
