package it.unicam.cs.model;

import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.model.abstractions.Utente;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.observer.ContestObservable;
import it.unicam.cs.observer.ContestObserver;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
/** Un contest è un evento di contribuzione organizzato da un animatore in cui partecipano degli utenti invitati
 * e che prevede la selezione di un vincitore **/
@Data
@Entity
public class Contest implements ContestObservable {
    @Id
    private Integer id;
    private String oggetto;
    private String descrizione;
    @Column(name = "data_inizio")
    private Date dataInizio;
    @Column(name = "data_fine")
    private Date dataFine;
    @OneToOne
    private POI luogo;
    private int partecipanti;
    @OneToMany
    private List<ContenutoMultimediale> contenutiCaricati;
    @OneToOne
    private ContenutoMultimediale contenutoVincitore;
    @OneToOne
    private Utente organizzatore;
    private boolean attivo = true;
    @OneToMany
    private List<ContestObserver> partecipantiContest;

    public Contest() {

    }

    /**Aggiunge un contenuto al contest se il contest risulta essere attivo
     * @param contenuto **/
    public void aggiungiContenuto(ContenutoMultimediale contenuto){
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
        if(LocalDate.now().isAfter(this.dataFine.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()))
        this.attivo = false;
    }

    /*** Restituisce il contenuto vincitore del contest
     * @return contenuto vincitore **/
    public void setContenutoVincitore(ContenutoMultimediale contenutoVincitore) {
        if(this.attivo && this.contenutoVincitore == null)
            this.contenutoVincitore = contenutoVincitore;
    }

    @Override
    public void aggiungiObserver(ContestObserver observer) {

    }

    @Override
    public void rimuoviObserver(ContestObserver observer) {

    }

    @Override
    public void notifica() {

    }
}
