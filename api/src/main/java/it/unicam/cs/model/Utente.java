package it.unicam.cs.model;


import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.ContenutoContest;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.observer.ContestObserver;
import it.unicam.cs.security.Token;
import it.unicam.cs.util.enums.RuoliUtente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/** Un utente è un entità iscritta alla piattaforma che può partecipare ai contest e contribuire con punti di interesse, eventi e contenuti
 * multimediali e a seconda del ruolo avrà diverse autorizzazioni **/
@Entity @Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Utente implements UserDetails,ContestObserver {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull @Column(unique = true)
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String nome;
    @NotNull
    private String cognome;
    private LocalDate dataDiNascita;
    @NotNull @Column(unique = true)
    private String email;
    private String sesso;
    private String telefono;
    @Builder.Default
    private int numeroDiContribuzioni = 0;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_comune_associato", referencedColumnName = "id")
    private Comune comuneAssociato;
    @ManyToMany(fetch = FetchType.EAGER) @Builder.Default
    private List<Ruolo> ruoli = new ArrayList<>();
    @ManyToMany  @Builder.Default
    private List<Contest> contestInPartecipazione = new ArrayList<>();
    @OneToMany(mappedBy = "utente")
    private List<Token> tokens;
    @ElementCollection
    private List<Integer> idContestVinti = new ArrayList<>();
    @OneToMany
    @JoinColumn(name = "id_poi_creato", referencedColumnName = "id")
    private List<POI> poiCreati;
    @OneToMany
    @JoinColumn(name = "id_itinerario_creato", referencedColumnName = "id")
    private List<Itinerario> itinerariCreati;
    @OneToMany
    @JoinColumn(name = "id_contenuto_multimediale_creato", referencedColumnName = "id")
    private List<ContenutoMultimediale> contenutiMultimediali;
    @OneToMany
    @JoinColumn(name = "id_evento_creato", referencedColumnName = "id")
    private List<Evento> eventiCreati;
    @OneToMany
    @JoinColumn(name = "id_contest_creato", referencedColumnName = "id")
    private List<Contest> contestCreati;
    @OneToMany
    @JoinColumn(name = "id_contenuto_contest_creato", referencedColumnName = "id")
    private List<ContenutoContest> contenutoContestCreati;

    @Override
    public void update(Integer idContest) {
        this.idContestVinti.add(idContest);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for(Ruolo ruolo: ruoli){
            authorities.add(new SimpleGrantedAuthority(ruolo.getNome()));
        }
        return authorities;
    }
    public void aggiungiPOI(POI poi){
        this.poiCreati.add(poi);
    }
    public void aggiungiItinerario(Itinerario itinerario){
        this.itinerariCreati.add(itinerario);
    }
    public void aggiungiContenutoMultimediale(ContenutoMultimediale contenutoMultimediale){
        this.contenutiMultimediali.add(contenutoMultimediale);
    }
    public void aggiungiEvento(Evento evento){
        this.eventiCreati.add(evento);
    }
    public void aggiungiContestCreato(Contest contest){
        this.contestCreati.add(contest);
    }
    public void aggiungiContenutoContestCreato(ContenutoContest contenutoContest){
        this.contenutoContestCreati.add(contenutoContest);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
