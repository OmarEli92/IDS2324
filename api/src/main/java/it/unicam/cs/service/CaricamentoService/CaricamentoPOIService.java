package it.unicam.cs.service.CaricamentoService;

import it.unicam.cs.Builder.POIBUILDER.POIBuilder;
import it.unicam.cs.Factory.POI.IPOIBuilderFactory;
import it.unicam.cs.Mediators.POIMediator;
import it.unicam.cs.Visitor.POI.IPOIBuilderVisitor;
import it.unicam.cs.exception.UtenteNotValidException;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.DTO.input.PoiDto;
import it.unicam.cs.model.Ruolo;
import it.unicam.cs.model.Utente;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.contenuti.ContenutoMultimediale;
import it.unicam.cs.service.CaricamentoService.Interfaces.ICaricamentoPOIService;
import it.unicam.cs.service.ControlloService.ControlloPOIService;
import it.unicam.cs.service.Interfaces.IUtenteService;
import it.unicam.cs.service.UtenteService;
import it.unicam.cs.util.enums.RuoliUtente;
import it.unicam.cs.util.enums.StatoElemento;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CaricamentoPOIService implements ICaricamentoPOIService {
    @Autowired
    private IUtenteService utenteService;
    @Autowired
    private  ControlloPOIService controlloPOIService;
    @Autowired
    private IPOIBuilderFactory poiBuilderFactory;
    @Autowired
    private IPOIBuilderVisitor poiBuilderVisitor;
    @Autowired
    private POIMediator poiMediator;
    @Override
    public void caricaPOI(PoiDto poiDto){
        controlloPOIService.verificaPOI(poiDto);
        POIBuilder poiBuilder = poiBuilderFactory.creaBuilder(poiDto);
        costrusciPOI(poiBuilder,poiDto);
        poiMediator.salvaPOI(poiBuilder.build());
    }
    
    private void costrusciPOI(POIBuilder poiBuilder, PoiDto poiDto) {
        Utente utente = utenteService.ottieniUtenteById(poiDto.getIdContributore());
        Comune comune = utente.getComuneAssociato();
        StatoElemento statoElemento = isPOIContributoreValid(utente, comune);
        poiBuilder.setNome(poiDto.getNome());
        poiBuilder.setPosizione(poiDto.getPosizione());
        poiBuilder.setContributore(utente);
        poiBuilder.setStato(statoElemento);
        poiBuilder.setComuneAssociato(utente.getComuneAssociato());
        poiBuilder.setEventiAssociati(new ArrayList<Evento>());
        poiBuilder.setContenutiMultimediali(new ArrayList<ContenutoMultimediale>());
        poiBuilder.accept(poiBuilderVisitor,poiDto);
    }
    @Transactional
    private StatoElemento isPOIContributoreValid(Utente utente, Comune comune) {
        StatoElemento stato;
        List<String> nomi = utente.getRuoli()
                .stream()
                .map(Ruolo::getNome)
                .collect(Collectors.toList());
        if(nomi.contains(RuoliUtente.CURATORE.name()) || nomi.contains(RuoliUtente.CONTRIBUTORE_AUTORIZZATO.name())){
            stato = StatoElemento.PUBBLICATO;
        }
        else{
            stato = StatoElemento.PENDING;
        }
        return stato;
    }
}