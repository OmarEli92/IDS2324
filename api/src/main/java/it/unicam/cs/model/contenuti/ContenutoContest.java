package it.unicam.cs.model.contenuti;

import it.unicam.cs.model.Contest;
import it.unicam.cs.model.Utente;
import it.unicam.cs.util.enums.TipoContenuto;
import jakarta.persistence.*;
import lombok.*;

@Entity @Getter @NoArgsConstructor
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

    public ContenutoContest(String nome, TipoContenuto tipo, Utente utenteCreatore, Contest contestAssociato) {
        this.nome = nome;
        this.tipo = tipo;
        this.utenteCreatore = utenteCreatore;
        this.contestAssociato = contestAssociato;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }

}
