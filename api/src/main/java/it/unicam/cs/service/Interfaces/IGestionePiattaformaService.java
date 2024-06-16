package it.unicam.cs.service.Interfaces;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.DTO.input.ComuneDto;

import java.util.Collection;

public interface IGestionePiattaformaService {
    /** Aggiunge comune
     * @Return id del comune aggiunto**/
    void aggiungiComune(ComuneDto comuneDto);
    /** Rimuove comune tramite id**/
    void rimuoviComune(int idComune);
    /** Rimuove comune tramite nome***/
    void rimuoviComune(String nomeComune);

    /**Aggiunge gestore Comune
     *@Return id gestore Comune **/
    Integer aggiungiGestoreComune(Integer gestoreComune,String comune, Integer userId);
    /**Rimuove gestore comune**/
    void rimuoviGestoreComune(int idGestore, String comune);
    /** Ottieni comune da id**/
    Comune ottieniComune(int idComune);
    /** Ottieni comune da nome**/
    Comune ottieniComune(String nomeComune);

    Collection<Comune> ottieniComuni(int pageNo, int pageSize);
}
