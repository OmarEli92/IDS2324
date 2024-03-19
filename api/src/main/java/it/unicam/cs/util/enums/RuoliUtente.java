package it.unicam.cs.util.enums;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

/**
 * Enumerazione dei ruoli degli utenti all'interno del sistema
 */
public enum RuoliUtente {
    AMMINISTRATORE_PIATTAFORMA("Amministratore_Piattaforma"),
    GESTORE_COMUNE("Gestore_Comune"),
    CURATORE("Curatore"),
    ANIMATORE("Animatore"),
    CONTRIBUTORE_AUTORIZZATO("Contributore_Autorizzato"),
    CONTRIBUTORE("Contributore"),
    TURISTA("Turista"),
    PARTECIPANTE_CONTEST("Partecipante_Contest");

    private final String ruolo;

    RuoliUtente(String ruolo) {
        this.ruolo = ruolo;
    }

}
