package it.unicam.cs.util.info;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * classe che serve per ricavare regione e provincia del comune
 */
@Embeddable
public class DettagliComune {
    private Posizione posizione;
    private String provincia;
    private String regione;

    public DettagliComune(Posizione posizione, String provincia, String regione) {
        this.posizione = posizione;
        this.provincia = provincia;
        this.regione = regione;
    }

    public DettagliComune() {
    }
}
