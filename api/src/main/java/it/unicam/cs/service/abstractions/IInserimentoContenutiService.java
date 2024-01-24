package it.unicam.cs.service.abstractions;

import it.unicam.cs.exception.POINotFoundException;
import it.unicam.cs.model.*;

import java.util.List;

/** L'interfaccia IInserimentoContenutiService è un servizio che gestisce tutta la logica di business relativa all'inserimento
 * dei contenuti nella piattaforma e fornisce metodi adibiti a tale scopo **/

public interface IInserimentoContenutiService {
void aggiungiPOI(POI poi) throws POINotFoundException;

void aggiungiEvento(Evento evento);

void aggiungiItinerario(Itinerario itinerario) throws POINotFoundException;

void aggiungiContenutoMultimediale(ContenutoMultimediale contenutoMultimediale);
}
