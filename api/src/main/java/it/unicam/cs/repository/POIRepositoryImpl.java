package it.unicam.cs.repository;


import it.unicam.cs.exception.POINotFoundException;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Curatore;
import it.unicam.cs.model.POI;
import java.util.Map;
import java.util.stream.Collectors;

public class POIRepositoryImpl implements POIRepository{

    private final Map<Integer, POI> pois;
    private final Comune comune;

    public POIRepositoryImpl(Map<Integer, POI> pois, Comune comune){
        this.pois = pois;
        this.comune=comune;
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
  @Override
    public void aggiungiPOI(POI poi) {
        this.comune.aggiungiPOI(POI poi);
    }

    @Override
    public void aggiungiPOIInPending(POI poi) {
        this.comune.aggiungiPOIInPending(poi);
    }



    public Curatore getCuratore(){
        return this.comune.getCuratore();
    }

    public Comune getComune() {
        return comune;
    }

    public void rimuoviPOIInPending(POI poi) {
        this.comune.rimoviPOIInPending(poi);
    }
}
