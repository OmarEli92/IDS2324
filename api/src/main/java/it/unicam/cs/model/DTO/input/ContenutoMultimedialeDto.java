package it.unicam.cs.model.DTO.input;

import jakarta.annotation.Nullable;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ContenutoMultimedialeDto {
    private String nome;
    private String tipoContenuto;
    private Integer idPoi;
    private Integer idEvento;
    private Integer idItinerario;
}
