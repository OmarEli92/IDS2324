package it.unicam.cs.model.DTO.input;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class InfoRuoloUtenteDto {
    private String username;
    private String ruolo;
}
