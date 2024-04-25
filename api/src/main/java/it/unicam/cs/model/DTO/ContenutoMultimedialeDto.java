package it.unicam.cs.model.DTO;

import jakarta.annotation.Nullable;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ContenutoMultimedialeDto {
    private Integer id;
    private String nome;
    private Integer idContributore;
    private String tipoContenuto;
    private Integer idPoi;
    private Integer idEvento;
}
