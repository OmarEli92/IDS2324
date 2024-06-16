package it.unicam.cs.model.DTO.output;

import lombok.Data;
import org.springframework.stereotype.Component;


public record UtenteDto (
        Integer id,
        String nome,
        String cognome,
        String username,
        String email,
        String comuneAssociato
){
}
