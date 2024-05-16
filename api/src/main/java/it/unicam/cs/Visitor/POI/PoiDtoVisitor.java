package it.unicam.cs.Visitor.POI;

import it.unicam.cs.exception.Contenuto.CollezioneNotValidException;
import it.unicam.cs.exception.Contenuto.ServiziNotValidException;
import it.unicam.cs.exception.Contenuto.ServiziUtiliNotValidException;
import it.unicam.cs.exception.Contenuto.TipoAmministrativoNotValidException;
import it.unicam.cs.exception.Contenuto.TipoIntrattenimentoNotValidException;
import it.unicam.cs.model.DTO.input.*;
import it.unicam.cs.util.Extensions.ValidationPOIExtension;
import it.unicam.cs.util.enums.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PoiDtoVisitor implements IPoiDtoVisitor{
    @Autowired
    ValidationPOIExtension validationPOIExtension;
    @Override
    public void visit(PoiAmministrativoDto poiAmministrativoDto) {
        controllaTipoAmministrativo(poiAmministrativoDto.getTipo());
        validationPOIExtension.isOrariAperturaValido(poiAmministrativoDto.getOrariApertura());
        validationPOIExtension.isResponsabileValido(poiAmministrativoDto.getResponsabile());
        validationPOIExtension.areContattiValidi(poiAmministrativoDto.getContatti());
    }
    private void controllaTipoAmministrativo(String tipo) {
        TipoAmministrativo[] tipi = TipoAmministrativo.values();
        for (TipoAmministrativo t : tipi){
            if(tipo.equalsIgnoreCase(t.name()))
                return;
        }
        throw new TipoAmministrativoNotValidException();
    }

    @Override
    public void visit(PoiIntrattenimentoDto poiIntrattenimentoDto) {
        controllaTipoIntrattenimento(poiIntrattenimentoDto.getTipo());
        validationPOIExtension.isEtaConsigliatiValida(poiIntrattenimentoDto.getEtaConsigliata());
        validationPOIExtension.isOrariAperturaValido(poiIntrattenimentoDto.getOrariApertura());
        validationPOIExtension.areContattiValidi(poiIntrattenimentoDto.getContatti());
        controllaServiziIntrattenimento(poiIntrattenimentoDto.getServiziOfferti());
    }
    private void controllaTipoIntrattenimento(String tipo) {
        TipoIntrattenimento[] tipi = TipoIntrattenimento.values();
        for (TipoIntrattenimento t : tipi){
            if(tipo.equalsIgnoreCase(t.name()))
                return;
        }
        throw new TipoIntrattenimentoNotValidException();
    }
    private void controllaServiziIntrattenimento(List<String> serviziOfferti) {
        boolean valid = serviziOfferti.stream().allMatch(value -> contieneValoreServizio(Servizio.class, value));
        if(!valid){
            throw new ServiziNotValidException();
        }
    }
    private <T extends Enum<T>> boolean contieneValoreServizio(Class<T> servizioClass, String name) {
        Servizio servizio = Enum.valueOf(Servizio.class, name.toUpperCase());
        if(servizio == null){
            return false;
        }
        return  true;
    }

    @Override
    public void visit(ParcoDto parcoDto) {
        validationPOIExtension.isOrariAperturaValido(parcoDto.getOrarioApertura());
        validationPOIExtension.isEstensioneValida(parcoDto.getEstensione());
    }

    @Override
    public void visit(MuseoDto museoDto) {
        validationPOIExtension.isOrariAperturaValido(museoDto.getOrariApertura());
        validationPOIExtension.isResponsabileValido(museoDto.getResponsabile());
        validationPOIExtension.areContattiValidi(museoDto.getContatti());
        validationPOIExtension.isNumeroSaleValid(museoDto.getNumeroSale());
        controllaCollezioni(museoDto.getCollezioni());
    }
    private void controllaCollezioni(List<String> collezioni) {
        boolean valid = collezioni.stream().allMatch(value -> contieneValoreEnum(CollezioniMuseo.class,value));
    }
    private <T extends Enum<T>> boolean contieneValoreEnum(Class<T> collezioniMuseoClass, String value) {
        CollezioniMuseo collezione = Enum.valueOf(CollezioniMuseo.class,value.toUpperCase());
        if(collezione == null){
            throw new CollezioneNotValidException();
        }
        return true;
    }

    @Override
    public void visit(PoiServiziUtiliDto poiServiziUtiliDto) {
        controllaServiziUtili(poiServiziUtiliDto.getServizio());
        validationPOIExtension.areContattiValidi(poiServiziUtiliDto.getContatti());
        validationPOIExtension.isOrariAperturaValido(poiServiziUtiliDto.getOrariApertura());
    }
    private void controllaServiziUtili(String servizio) {
        ServiziUtili[] servizi = ServiziUtili.values();
        for (ServiziUtili s : servizi){
            if(servizio.equalsIgnoreCase(s.name())){
                return;
            }
        }
        throw new ServiziUtiliNotValidException();
    }

    @Override
    public void visit(MonumentoDto monumentoDto) {
        validationPOIExtension.isAnnoRealizzazioneValid(monumentoDto.getAnnoRealizzazione());
        validationPOIExtension.isDescrizioneValid(monumentoDto.getDescrizione());
        validationPOIExtension.isAutoreValid(monumentoDto.getAutore());
        validationPOIExtension.isAltezzaValid(monumentoDto.getAltezza());
        validationPOIExtension.isLunghezzaValid(monumentoDto.getLunghezza());
        validationPOIExtension.isArchitetturaValid(monumentoDto.getArchitettura());
    }
}
