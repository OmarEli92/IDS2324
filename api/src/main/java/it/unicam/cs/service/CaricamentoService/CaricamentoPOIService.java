package it.unicam.cs.service.CaricamentoService;

import it.unicam.cs.Builder.POIBUILDER.POIAmministrativoBuilder;
import it.unicam.cs.Builder.POIBUILDER.POIBuilder;
import it.unicam.cs.Builder.POIBUILDER.POIIntrattenimentoBuilder;
import it.unicam.cs.Factory.POI.IPOIBuilderFactory;
import it.unicam.cs.model.DTO.*;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.service.ControlloPOIService.ControlloPOIService;
import it.unicam.cs.service.UtenteService;
import it.unicam.cs.util.enums.TipoIntrattenimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CaricamentoPOIService {
    @Autowired
    private  UtenteService utenteService;
    @Autowired
    private  ControlloPOIService controlloPOIService;
    @Autowired
    private IPOIBuilderFactory poiBuilderFactory;
    public void caricaPOI(PoiDto poiDto){
        controlloPOIService.verificaPOI(poiDto);
        POIBuilder poiBuilder = poiBuilderFactory.creaBuilder(poiDto);
        costrusciPOI(poiBuilder,poiDto);
    }
    
    private void costrusciPOI(POIBuilder poiBuilder, PoiDto poiDto) {
        poiBuilder.setId(poiBuilder.getId());
        poiBuilder.setNome(poiBuilder.getNome());
        poiBuilder.setPosizione(poiBuilder.getPosizione());
        poiBuilder.setContributore(utenteService.ottieniUtenteById(poiDto.getIDContributore()));
        poiBuilder.setStato(utenteService.ottieniUtenteById(poiDto.getIDContributore()));
        poiBuilder.setComuneAssociato(utenteService.ottieniUtenteById(poiDto.getIDContributore()).getComuneAssociato());
        poiBuilder.setEventiAssociati(new ArrayList<Evento>());
        poiBuilder.setContenutiMultimediali(new ArrayList<ContenutoMultimediale>());

    }

    private void costruisciPOIAmministrativo(POIAmministrativoBuilder poiBuilder, PoiAmministrativoDto poiDto) {
    }

}