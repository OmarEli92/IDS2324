package it.unicam.cs.model.DTO.input;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class EliminazioneContenutoDto {
   private Integer idUtente;
   private Integer idContenutoMultimediale;
   private boolean eliminato;
}
