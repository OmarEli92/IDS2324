package it.unicam.cs.security.request;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Ruolo;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class RegisterRequest {
    private String nome;
    private String cognome;
    private String username;
    private String email;
    private String password;
    private String telefono;
    private String sesso;
    private LocalDate dataDiNascita;
    private String comuneAssociato;
}
