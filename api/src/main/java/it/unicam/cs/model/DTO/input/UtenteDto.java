package it.unicam.cs.model.DTO.input;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UtenteDto {

    private Integer id;
    private String nome;
    private String cognome;
    private String username;
    private String email;
    private String comuneAssociato;

}
