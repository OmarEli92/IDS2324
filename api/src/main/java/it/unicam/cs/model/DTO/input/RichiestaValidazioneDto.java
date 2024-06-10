package it.unicam.cs.model.DTO.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class RichiestaValidazioneDto {
    private Integer idContenuto;
    private boolean validato;
}
