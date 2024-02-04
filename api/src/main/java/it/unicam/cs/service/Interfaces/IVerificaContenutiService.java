package it.unicam.cs.service.Interfaces;

import it.unicam.cs.model.Abstractions.Contenuto;

public interface IVerificaContenutiService {
    void verificaContenuto(Contenuto contenuto);
    void validaContenuto(Contenuto contenuto);
    void invalidaContenuto(Contenuto contenuto);
}
