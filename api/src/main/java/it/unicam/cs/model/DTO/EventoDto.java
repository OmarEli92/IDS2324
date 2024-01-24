package it.unicam.cs.model.DTO;

import it.unicam.cs.util.Posizione;

/** La classe ItinerarioDto è un Data Transfer Object per la classe Itinerario serve principlamente per ottenere
 * solo le informazioni principali sull'evento nel territorio quali id,nome,posizione,idComune e idContributore
 * senza dover scaricare tutte le informazioni relative ad un evento del territorio
 * **/
public record EventoDto (
    Integer ID,
    String nome,
    Posizione posizione,
    String descrizione,
    Integer IDComune,
    Integer IDContributore,
    String tipo
){

}
