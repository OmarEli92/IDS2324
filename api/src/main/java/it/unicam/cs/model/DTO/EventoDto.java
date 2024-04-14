package it.unicam.cs.model.DTO;

import it.unicam.cs.util.info.Posizione;
import lombok.Data;
import org.springframework.stereotype.Component;


/** La classe EventoDto è un Data Transfer Object per la classe Evento serve principlamente per ottenere

 * solo le informazioni principali sull'evento nel territorio quali id,nome,posizione,idComune e idContributore
 * senza dover scaricare tutte le informazioni relative ad un evento del territorio
 * **/
@Component
@Data
public class EventoDto{
    private Integer ID;
    private String nome;
    private Posizione posizione;
    private String descrizione;
    private Integer IDComune;
    private Integer IDContributore;
    private String tipo;

}

