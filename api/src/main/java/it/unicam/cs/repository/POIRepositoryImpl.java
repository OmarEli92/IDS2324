package it.unicam.cs.repository;

import it.unicam.cs.model.POI;

import java.util.List;
import java.util.Map;

public class POIRepositoryImpl implements POIRepository {

    @Override
    public Map<Integer, POI> ottieniPOIS() {
        return null;
    }

    @Override
    public POI ottieniPOIDaID(int idPOI) {
        return null;
    }

    @Override
    public void aggiungiPOI(POI poi) {
        poi.getComuneAssociato().getPOISInPending().add(poi);
    }

    @Override
    public void aggiungiPOIInPending(POI poi) {
        poi.getComuneAssociato().getPOIS().add(poi);
    }

}
