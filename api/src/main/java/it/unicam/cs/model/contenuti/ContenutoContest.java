package it.unicam.cs.model.contenuti;

import it.unicam.cs.model.Contest;
import it.unicam.cs.model.Utente;
import it.unicam.cs.util.enums.TipoContenuto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity @NoArgsConstructor  @AllArgsConstructor @Data
public class ContenutoContest {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private TipoContenuto tipo;
    private boolean pending = true;
    @ManyToOne(fetch = FetchType.LAZY)
    private Utente utenteCreatore;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name ="id_contest_associato",referencedColumnName = "id")
    private Contest contestAssociato;
}
