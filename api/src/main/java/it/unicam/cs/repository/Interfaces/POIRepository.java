package it.unicam.cs.repository.Interfaces;

import it.unicam.cs.model.POI;

import java.util.Map;

public interface POIRepository {
  
    /** Il metodo ottieniPOIS restituisce una mappa di POI **/
    Map<Integer, POI> ottieniPOIS(int idComune);
    /** Il metodo ottieniPOIDaID restituisce un POI a partire dal suo id **/
    POI ottieniPOIdaID(int idPOI);
    void aggiungiPOI(POI poi);
    void aggiungiPOIInPending(POI poi);

}
