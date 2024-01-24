package it.unicam.cs.repository;

import it.unicam.cs.exception.POINotFoundException;
import it.unicam.cs.model.POI;
import java.util.Map;
import java.util.stream.Collectors;

public class POIRepositoryImpl implements POIRepository{

    private final Map<Integer, POI> pois;

    public POIRepositoryImpl(Map<Integer, POI> pois){
        this.pois = pois;
    }

    @Override
    public Map<Integer, POI> ottieniPOIS(int idComune) {
        return pois.values()
                .stream()
                .filter(poi -> poi.getIDComune() == idComune)
                .collect(Collectors.toMap(POI::getID, poi-> poi));
    }

    @Override
    public POI ottieniPOIdaID(int idPOI){
            return pois.get(idPOI);
        }

}
