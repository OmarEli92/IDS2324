package it.unicam.cs.model.contenuti;

import it.unicam.cs.model.Utente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity @NoArgsConstructor  @AllArgsConstructor @Data
public class ContenutoContest {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private ContenutoMultimediale contenutoMultimediale;
    @OneToOne
    private Utente partecipante;
}
