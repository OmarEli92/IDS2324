package it.unicam.cs.service.CaricamentoService;

import it.unicam.cs.Builder.POIBUILDER.POIBuilder;
import it.unicam.cs.Factory.POI.IPOIBuilderFactory;
import it.unicam.cs.Mediators.POIMediator;
import it.unicam.cs.Visitor.POI.IPOIBuilderVisitor;
import it.unicam.cs.model.DTO.input.PoiDto;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.service.ControlloService.ControlloPOIService;
import it.unicam.cs.service.UtenteService;
import it.unicam.cs.util.enums.RuoliUtente;
import it.unicam.cs.util.enums.StatoElemento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CaricamentoPOIService {
    @Autowired
    private  UtenteService utenteService;
    @Autowired
    private  ControlloPOIService controlloPOIService;
    @Autowired
    private IPOIBuilderFactory poiBuilderFactory;
    @Autowired
    private IPOIBuilderVisitor poiBuilderVisitor;
    @Autowired
    private POIMediator poiMediator;
    public void caricaPOI(PoiDto poiDto){
        controlloPOIService.verificaPOI(poiDto);
        POIBuilder poiBuilder = poiBuilderFactory.creaBuilder(poiDto);
        costrusciPOI(poiBuilder,poiDto);
        poiMediator.salvaPOI(poiBuilder.build());
    }
    
    private void costrusciPOI(POIBuilder poiBuilder, PoiDto poiDto) {
        Utente utente = utenteService.ottieniUtenteById(poiDto.getIDContributore());
        StatoElemento statoElemento;
        List<String> nomi = utente.getRuoli()
                        .stream()
                        .map(Ruolo::getNome)
                        .collect(Collectors.toList());
        if(nomi.contains(RuoliUtente.CURATORE.name()) || nomi.contains(RuoliUtente.CONTRIBUTORE_AUTORIZZATO.name())){
            statoElemento = StatoElemento.PUBBLICATO;
        }
        else{
            statoElemento = StatoElemento.PENDING;
        }
        poiBuilder.setNome(poiBuilder.getNome());
        poiBuilder.setPosizione(poiDto.getPosizione());
        poiBuilder.setContributore(utente);
        poiBuilder.setStato(statoElemento);
        poiBuilder.setComuneAssociato(utente.getComuneAssociato());
        poiBuilder.setEventiAssociati(new ArrayList<Evento>());
        poiBuilder.setContenutiMultimediali(new ArrayList<ContenutoMultimediale>());
        poiBuilder.accept(poiBuilderVisitor,poiDto);
    }


}