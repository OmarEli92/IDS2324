package it.unicam.cs.util.enums;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

/**
 * Enumerazione dei ruoli degli utenti all'interno del sistema
 */
public enum RuoliUtente {
    GESTORE_PIATTAFORMA("GESTORE_PIATTAFORMA"),
    GESTORE_COMUNE("GESTORE_COMUNE"),
    CURATORE("CURATORE"),
    ANIMATORE("ANIMATORE"),
    CONTRIBUTORE_AUTORIZZATO("CONTRIBUTORE_AUTORIZZATO"),
    CONTRIBUTORE("CONTRIBUTORE"),
    TURISTA("TURISTA"),
    PARTECIPANTE_CONTEST("PARTECIPANTE_CONTEST");

    private final String ruolo;

    RuoliUtente(String ruolo) {
        this.ruolo = ruolo;
    }

}
