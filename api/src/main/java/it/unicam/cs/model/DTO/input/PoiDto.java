package it.unicam.cs.model.DTO.input;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import it.unicam.cs.Visitor.POI.IPoiDtoVisitable;
import it.unicam.cs.Visitor.POI.IPoiDtoVisitor;
import it.unicam.cs.util.info.Posizione;
import lombok.Data;
import org.springframework.stereotype.Component;

/** La classe PoiDTO è un Data Transfer Object per la classe Itinerario serve principlamente per ottenere
 * solo le informazioni principali sul POI del territorio quali id,nome,posizione,idComune e idContributore
 * senza dover scaricare tutte le informazioni relative ad un POI del territorio**/

@Component
@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tipoPoi"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PoiIntrattenimentoDto.class, name = "intrattenimento"),
        @JsonSubTypes.Type(value = PoiAmministrativoDto.class, name = "amministrativo"),
        @JsonSubTypes.Type(value = PoiServiziUtiliDto.class, name = "servizi utili"),
        @JsonSubTypes.Type(value = ParcoDto.class, name = "parco"),
        @JsonSubTypes.Type(value = MuseoDto.class, name = "Museo"),
        @JsonSubTypes.Type(value = MonumentoDto.class, name = "Monumento")
})
@Schema(description = "Base class for all POI types")
public abstract class PoiDto implements IPoiDtoVisitable {
    private String tipoPoi;
    private String nome;
    private Posizione posizione;

    public abstract void accept (IPoiDtoVisitor poiDtoVisitor);
}
