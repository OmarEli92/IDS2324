package it.unicam.cs.model;

import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.contenuti.ContenutoContest;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.observer.ContestObservable;
import it.unicam.cs.util.enums.TipoInvito;
import it.unicam.cs.util.enums.TipoPOI;
import it.unicam.cs.util.info.Posizione;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/** Un contest è un evento di contribuzione organizzato da un animatore in cui partecipano degli utenti invitati
 * e che prevede la selezione di un vincitore **/

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Contest implements ContestObservable<Utente> {
    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;
    private String descrizione;
    @Column(name = "data_inizio")
    private LocalDate dataInizio;
    @Column(name = "data_fine")
    private LocalDate dataFine;
    private int partecipanti;
    @ManyToOne
    @JoinColumn(name = "id_poi_associato", referencedColumnName = "id")
    private POI poiAssociato;
    @ManyToOne()
    @JoinColumn(name = "id_comune_associato", referencedColumnName = "id")
    private Comune comuneAssociato;
    @OneToMany
    private List<ContenutoContest> contenutiCaricati;
    @OneToOne
    private ContenutoContest contenutoVincitore;
    @ManyToOne
    private Utente organizzatore;
    private boolean attivo ;
    private TipoInvito tipoInvito;
    @ManyToOne
    private Utente vincitore;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "partecipanti_contest",
            joinColumns = @JoinColumn(name = "id_contest", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_utente", referencedColumnName = "id")
    )
    private List<Utente> partecipantiContest;

    public Contest(String descrizione, LocalDate dataInizio, LocalDate dataFine, int partecipanti, POI poiAssociato, Comune comuneAssociato, Utente organizzatore, boolean attivo, TipoInvito tipoInvito) {
        this.descrizione = descrizione;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.partecipanti = partecipanti;
        this.poiAssociato = poiAssociato;
        this.comuneAssociato = comuneAssociato;
        this.organizzatore = organizzatore;
        this.attivo = attivo;
        this.tipoInvito = tipoInvito;
    }

    public void setAttivo(boolean attivo) {
        this.attivo = attivo;
    }

    /**Aggiunge un contenuto al contest se il contest risulta essere attivo
     * @param contenuto **/
    public void aggiungiContenutoCaricato(ContenutoContest contenuto){
        if(contenuto == null)
            throw new NullPointerException("Il contenuto non può essere nullo");
        if(this.attivo)
            this.contenutiCaricati.add(contenuto);
        else throw new IllegalStateException("Il contest è chiuso");
    }

    /*** Rimuove un contenuto dal contest
     * @param contenuto **/
    public void rimuoviContenuto(ContenutoMultimediale contenuto){
        if(contenuto != null) {
            this.contenutiCaricati.remove(contenuto);
        }
        else throw new NullPointerException("Il contenuto non può essere nullo");
    }

    /*** Chiude il contest **/
    public void chiudiContest(){
        if(LocalDate.now().isAfter(this.dataFine) || contenutoVincitore != null)
        this.attivo = false;
    }

    /*** Restituisce il contenuto vincitore del contest
     * @return contenuto vincitore **/
    public void setVincitore(ContenutoContest contenutoVincitore,Utente partecipante) {
        if(this.attivo && this.contenutoVincitore == null)
            this.contenutoVincitore = contenutoVincitore;
        this.vincitore = partecipante;
        chiudiContest();
    }

    @Override
    public void aggiungiObserver(Utente osservatore) {
        partecipantiContest.add(osservatore);
        osservatore.getContestInPartecipazione().add(this);
    }

    @Override
    public void rimuoviObserver(Utente osservatore) {
        partecipantiContest.remove(osservatore);
        osservatore.getContestInPartecipazione().remove(this);
    }

    @Override
    public void notifica() {
        vincitore.getIdContestVinti().add(this.id);
        partecipantiContest.stream()
                .map(partecipante -> partecipante.getContestInPartecipazione().remove(this));
    }

}
