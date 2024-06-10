package it.unicam.cs.model.DTO.input;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ContenutoContestDto {
    private String nome;
    private String tipoContenuto;
    private Integer idContestAssociato;
}
