package it.unicam.cs.service.Interfaces;

import it.unicam.cs.model.Comune;
import it.unicam.cs.model.DTO.ComuneDTO;
import it.unicam.cs.model.DTO.input.ComuneDto;
import it.unicam.cs.model.Utente;

import java.util.Collection;
import java.util.Optional;

public interface IGestionePiattaformaService {
    /** Aggiunge comune
     * @Return id del comune aggiunto**/
    void aggiungiComune(Integer userId, ComuneDto comuneDto);
    /** Rimuove comune tramite id**/
    void rimuoviComune(int idComune);
    /** Rimuove comune tramite nome***/
    void rimuoviComune(String nomeComune);

    /**Aggiunge gestore Comune
     *@Return id gestore Comune **/
    int aggiungiGestoreComune(Integer gestoreComune,String comune);
    /**Rimuove gestore comune**/
    void rimuoviGestoreComune(int idGestore, String comune);
    /** Ottieni comune da id**/
    Comune ottieniComune(int idComune);
    /** Ottieni comune da nome**/
    Comune ottieniComune(String nomeComune);

    Collection<ComuneDTO> ottieniComuni(int pageNo, int pageSize);
}
