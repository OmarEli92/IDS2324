package it.unicam.cs.model.DTO;
/** La classe ItinerarioDto è un Data Transfer Object per la classe Itinerario serve principlamente per ottenere
 * solo le informazioni principali sull'itinerario nel territorio quali id,nome,posizione,idComune e idContributore
 * senza dover scaricare tutte le informazioni relative ad un itinerario del territorio**/
public class ItinerarioDto {
    private Integer ID;
    private String nome;
    private String descrizione;
    private Integer IDComune;
    private Integer IDContributore;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIDComune() {
        return IDComune;
    }

    public void setIDComune(Integer IDComune) {
        this.IDComune = IDComune;
    }

    public Integer getIDContributore() {
        return IDContributore;
    }

    public void setIDContributore(Integer IDContributore) {
        this.IDContributore = IDContributore;
    }



    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
