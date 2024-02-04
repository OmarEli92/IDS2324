package it.unicam.cs.repository.Interfaces;

import it.unicam.cs.model.Abstractions.Contenuto;
import it.unicam.cs.model.Curatore;

public interface ContenutoRepository {
void aggiungiContenuto(Contenuto contenuto);
void aggiungiContenutoInPending(Contenuto contenuto);
Curatore getCuratore();
void rimuoviContenutoInPending(Contenuto contenuto);
}
