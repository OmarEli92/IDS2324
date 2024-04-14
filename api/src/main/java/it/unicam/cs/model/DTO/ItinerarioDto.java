package it.unicam.cs.model.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

/** La classe ItinerarioDto è un Data Transfer Object per la classe Itinerario serve principlamente per ottenere
 * solo le informazioni principali sull'itinerario nel territorio quali id,nome,posizione,idComune e idContributore
 * senza dover scaricare tutte le informazioni relative ad un itinerario del territorio**/
@Component
@Data
public class ItinerarioDto {

    private Integer ID;
    private String nome;
    private String descrizione;
    private Integer IDComune;
    private Integer IDContributore;

}
