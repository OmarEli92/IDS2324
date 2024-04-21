package it.unicam.cs.model.DTO;

import it.unicam.cs.Visitor.IPoiDtoVisitable;
import it.unicam.cs.Visitor.IPoiDtoVisitor;
import it.unicam.cs.util.info.Posizione;
import lombok.Data;
import org.springframework.stereotype.Component;

/** La classe PoiDTO è un Data Transfer Object per la classe Itinerario serve principlamente per ottenere
 * solo le informazioni principali sul POI del territorio quali id,nome,posizione,idComune e idContributore
 * senza dover scaricare tutte le informazioni relative ad un POI del territorio**/
@Component
@Data
public abstract class PoiDto implements IPoiDtoVisitable {
    private String tipoPoi;
    private Integer ID;
    private String nome;
    private Posizione posizione;
    private Integer IDContributore;

    public abstract void accept (IPoiDtoVisitor poiDtoVisitor);
}
