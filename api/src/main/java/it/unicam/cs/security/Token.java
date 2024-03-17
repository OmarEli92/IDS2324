package it.unicam.cs.security;

import it.unicam.cs.model.Utente;
import jakarta.persistence.*;
import lombok.Data;

@Entity @Data
public class Token {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String token;
    @Column(name = "is_logged_out")
    private boolean isLoggedOut;
    @ManyToOne
    @JoinColumn(name = "id_utente",referencedColumnName = "id")
    private Utente utente;
}
