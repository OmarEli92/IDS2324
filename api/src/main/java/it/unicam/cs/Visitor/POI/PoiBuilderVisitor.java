package it.unicam.cs.Visitor.POI;

import it.unicam.cs.Builder.POIBUILDER.*;
import it.unicam.cs.model.DTO.*;
import it.unicam.cs.model.contenuti.Itinerario;
import it.unicam.cs.util.enums.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;
@Component
public class PoiBuilderVisitor implements IPOIBuilderVisitor{
    @Override
    public void visit(POIAmministrativoBuilder poiAmministrativoBuilder, PoiAmministrativoDto poiAmministrativoDto) {
        poiAmministrativoBuilder.setTipo(TipoAmministrativo.valueOf(poiAmministrativoDto.getTipo().toUpperCase()));
        poiAmministrativoBuilder.setOrariApertura(poiAmministrativoDto.getOrariApertura());
        poiAmministrativoBuilder.setResponsabile(poiAmministrativoDto.getResponsabile());
        poiAmministrativoBuilder.setContatti(poiAmministrativoDto.getContatti());
    }

    @Override
    public void visit(POIIntrattenimentoBuilder poiIntrattenimentoBuilder, PoiIntrattenimentoDto poiIntrattenimentoDto) {
        poiIntrattenimentoBuilder.setTipo(TipoIntrattenimento.valueOf(poiIntrattenimentoDto.getTipo().toUpperCase()));
        poiIntrattenimentoBuilder.setEtaConsigliata(poiIntrattenimentoDto.getEtaConsigliata());
        poiIntrattenimentoBuilder.setOrariApertura(poiIntrattenimentoDto.getOrariApertura());
        poiIntrattenimentoBuilder.setServiziOfferti(poiIntrattenimentoDto.getServiziOfferti().stream()
                .map(Servizio:: valueOf)
                .collect(Collectors.toList()));
        poiIntrattenimentoBuilder.setContatti(poiIntrattenimentoDto.getContatti());
    }

    @Override
    public void visit(ParcoBuilder parcoBuilder, ParcoDto parcoDto) {
        parcoBuilder.setPresenzaSpecieProtetta(parcoDto.isPresenzaSpecieProtetta());
        parcoBuilder.setOrarioApertura(parcoDto.getOrarioApertura());
        parcoBuilder.setPercorsi(new ArrayList<Itinerario>());
        parcoBuilder.setPresenzaAnimali(parcoDto.isPresenzaAnimali());
        parcoBuilder.setEstensione(parcoDto.getEstensione());
    }

    @Override
    public void visit(MuseoBuilder museoBuilder, MuseoDto museoDto) {
        museoBuilder.setOrariApertura(museoDto.getOrariApertura());
        museoBuilder.setResponsabile(museoDto.getResponsabile());
        museoBuilder.setContatti(museoDto.getContatti());
        museoBuilder.setNumeroSale(museoDto.getNumeroSale());
        museoBuilder.setCollezioni(museoDto.getCollezioni().stream()
                .map(CollezioniMuseo :: valueOf)
                .collect(Collectors.toList()));
    }

    @Override
    public void visit(POIServiziUtiliBuilder poiServiziUtiliBuilder, PoiServiziUtiliDto poiServiziUtiliDto) {
        poiServiziUtiliBuilder.setServizio(ServiziUtili.valueOf(poiServiziUtiliDto.getServizio().toUpperCase()));
        poiServiziUtiliBuilder.setContatti(poiServiziUtiliDto.getContatti());
        poiServiziUtiliBuilder.setOrariApertura(poiServiziUtiliDto.getOrariApertura());
    }

    @Override
    public void visit(MonumentoBuilder monumentoBuilder, MonumentoDto monumentoDto) {
        monumentoBuilder.setAnnoRealizzazione(monumentoDto.getAnnoRealizzazione());
        monumentoBuilder.setDescrizione(monumentoDto.getDescrizione());
        monumentoBuilder.setAutore(monumentoDto.getAutore());
        monumentoBuilder.setAltezza(monumentoDto.getAltezza());
        monumentoBuilder.setLunghezza(monumentoDto.getLunghezza());
        monumentoBuilder.setArchitettura(monumentoDto.getArchitettura());
    }
}
