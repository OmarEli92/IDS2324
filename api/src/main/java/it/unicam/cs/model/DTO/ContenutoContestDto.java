package it.unicam.cs.model.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ContenutoContestDto {
    private Integer id;
    private String nome;
    private String tipoContenuto;
    private Integer idUtente;
    private Integer idContestAssociato;
}
