package it.unicam.cs.model.DTO.input;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class RichiestaSegnalazioneDto {
    private Integer idUtenteSegnalatore;
    private Integer idContenuto;
}