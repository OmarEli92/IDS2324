package it.unicam.cs.service.Interfaces;

import it.unicam.cs.model.ContenutoMultimediale;
import it.unicam.cs.model.Evento;
import it.unicam.cs.model.Itinerario;
import it.unicam.cs.model.POI;

import java.util.List;

/** L'interfaccia IInserimentoContenutiService è un servizio che gestisce tutta la logica di business relativa all'inserimento
 * dei contenuti nella piattaforma e fornisce metodi adibiti a tale scopo **/

public interface IInserimentoContenutiService {


void rimuoviPOIInPending(POI poi);
void aggiungiContenutoMultimedialeInPending(ContenutoMultimediale contenutoMultimediale);
void rimuoviContenutoMultimedialeInPending(ContenutoMultimediale contenutoMultimediale);
void aggiungiContenutoMultimediale(ContenutoMultimediale contenutoMultimediale);
void aggiungiEventoInPending(Evento contenutoMultimediale);
void rimuoviEventoInPending(Evento contenutoMultimediale);
void aggiungiEvento(Evento contenutoMultimediale);
void aggiungiItinerarioInPending(Itinerario contenutoMultimediale);
void rimuoviItinerarioInPending(Itinerario contenutoMultimediale);
void aggiungiItinerario(Itinerario contenutoMultimediale);



}

