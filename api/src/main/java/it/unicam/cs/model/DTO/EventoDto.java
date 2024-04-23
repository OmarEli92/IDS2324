package it.unicam.cs.model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.unicam.cs.Visitor.Evento.IEventoDtoVisitable;
import it.unicam.cs.Visitor.Evento.IEventoDtoVisitor;
import it.unicam.cs.util.info.Posizione;
import lombok.Data;
import org.springframework.stereotype.Component;


/** La classe EventoDto è un Data Transfer Object per la classe Evento serve principlamente per ottenere

 * solo le informazioni principali sull'evento nel territorio quali id,nome,posizione,idComune e idContributore
 * senza dover scaricare tutte le informazioni relative ad un evento del territorio
 * **/
@Component
@Data
public abstract class EventoDto implements IEventoDtoVisitable {
    private Integer Id;
    @JsonIgnore
    private String tipoEvento;
    private String nome;
    private Posizione posizione;
    private String descrizione;
    private Integer IDPoi;
    private Integer IDContributore;
    private String tipo;

    @Override
    public abstract void accept(IEventoDtoVisitor eventoDtoVisitor);
}

