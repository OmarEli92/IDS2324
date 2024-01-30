package it.unicam.cs.repository;


import it.unicam.cs.model.Comune;
import it.unicam.cs.model.Contenuto;
import it.unicam.cs.model.Curatore;
import it.unicam.cs.model.POI;
import it.unicam.cs.repository.Abstractions.AbstractContenutoRepository;
import it.unicam.cs.repository.Interfaces.POIRepository;

import java.util.Map;
import java.util.stream.Collectors;

public class POIRepositoryImpl extends AbstractContenutoRepository {

    private final Map<Integer, POI> pois;

    public POIRepositoryImpl(Comune comune, Map<Integer, POI> pois) {
        super(comune);
        this.pois = pois;
    }

    public Map<Integer, POI> ottieniPOIS(int idComune) {
        return pois.values()
                .stream()
                .filter(poi -> poi.getIDComune() == idComune)
                .collect(Collectors.toMap(POI::getID, poi-> poi));
    }

    public POI ottieniPOIdaID(int idPOI){
            return pois.get(idPOI);
        }
  @Override
    public void aggiungiContenuto(Contenuto poi) {
        this.comune.aggiungiPOI((POI) poi);
    }

    @Override
    public void aggiungiContenutoInPending(Contenuto poi) {
        this.comune.aggiungiPOIInPending((POI) poi);
    }

    public void rimuoviContenutoInPending(POI poi) {
        this.comune.rimoviPOIInPending((POI) poi);
    }
    public Comune getComune(){
        return this.comune;
    }
}
