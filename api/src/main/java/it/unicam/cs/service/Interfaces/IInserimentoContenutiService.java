package it.unicam.cs.service.Interfaces;

/** L'interfaccia IInserimentoContenutiService è un servizio che gestisce tutta la logica di business relativa all'inserimento
 * dei contenuti nella piattaforma e fornisce metodi adibiti a tale scopo **/

public interface IInserimentoContenutiService {
void aggiungiContenuto(Contenuto contenuto);
void aggiungiContenutoInPending(Contenuto contenuto);
}
