package it.unicam.cs.model.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import it.unicam.cs.util.enums.CollezioniMuseo;
import it.unicam.cs.util.info.Contatti;
import jakarta.persistence.Embedded;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@ApiModel(description = "dto per un museo")
@Component
@Data
public class MuseoDto extends PoiDto {
    private String orariApertura;
    private String responsabile;
    @Embedded
    private Contatti contatti;
    private int numeroSale;
    private List<String> collezioni;
}
