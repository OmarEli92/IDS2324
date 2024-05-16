package it.unicam.cs.model.DTO.input;

import it.unicam.cs.util.info.Posizione;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class ComuneDto {
    private Integer idGestore;
    private String nome;
    private List<Posizione> territorio;
}
