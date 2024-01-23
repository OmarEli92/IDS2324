package it.unicam.cs.repository;

import it.unicam.cs.model.POI;

import java.util.Map;

public interface POIRepository {
    /** Il metodo ottieniPOIS restituisce una mappa di POI **/
    Map<Integer, POI> ottieniPOIS();
    /** Il metodo ottieniPOIDaID restituisce un POI a partire dal suo id **/
    POI ottieniPOIDaID(int idPOI);
    void aggiungiPOI(POI poi);
    void aggiungiPOIInPending(POI poi);

}
