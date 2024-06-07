package it.unicam.cs.model.DTO.input;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import it.unicam.cs.Visitor.Evento.IEventoDtoVisitable;
import it.unicam.cs.Visitor.Evento.IEventoDtoVisitor;
import it.unicam.cs.util.info.Posizione;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


/** La classe EventoDto è un Data Transfer Object per la classe Evento serve principlamente per ottenere

 * solo le informazioni principali sull'evento nel territorio quali id,nome,posizione,idComune e idContributore
 * senza dover scaricare tutte le informazioni relative ad un evento del territorio
 * **/
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tipoEvento"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = EventoIntrattenimentoDto.class, name = "intrattenimento"),
        @JsonSubTypes.Type(value = EventoTuristicoDto.class, name = "turistico"),
        @JsonSubTypes.Type(value = EventoAmministrativoDto.class, name = "amministrativo")
})
@Component
@Data
public abstract class EventoDto implements IEventoDtoVisitable {
    private Integer Id;
    private String tipoEvento;
    private String nome;
    private String descrizione;
    private LocalDateTime dataInizio;
    private LocalDateTime dataFine;
    private Integer IdPoi;
    private Integer IdContributore;

    @Override
    public abstract void accept(IEventoDtoVisitor eventoDtoVisitor);
}

