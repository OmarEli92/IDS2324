package it.unicam.cs.model.contenuti;

import it.unicam.cs.model.Utente;
import it.unicam.cs.model.Comune;
import it.unicam.cs.model.abstractions.Evento;
import it.unicam.cs.model.abstractions.POI;
import it.unicam.cs.util.enums.Servizio;
import it.unicam.cs.util.enums.StatoElemento;
import it.unicam.cs.util.enums.TipoIntrattenimento;
import it.unicam.cs.util.info.Contatti;
import it.unicam.cs.util.info.Indirizzo;
import it.unicam.cs.util.info.Posizione;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
 @Entity
 @Data
 @AllArgsConstructor
public final class POIIntrattenimento extends POI {
     private TipoIntrattenimento tipo;
     private int etaConsigliata;
     private String orariApertura;
     @ElementCollection
     @Enumerated(EnumType.STRING)
     private List<Servizio> serviziOfferti;
     @Embedded
     private Contatti contatti;

     public POIIntrattenimento(Integer id, String nome, Posizione posizione, Utente contributore, StatoElemento stato, Comune comuneAssociato, Indirizzo indirizzo, List<Evento> eventiAssociati, List<ContenutoMultimediale> contenutiMultimediali,TipoIntrattenimento tipo, int etaConsigliata, String orariApertura, List<Servizio> serviziOfferti, Contatti contatti) {
         super(id, nome, posizione, contributore, stato, comuneAssociato, indirizzo, eventiAssociati, contenutiMultimediali);
         this.tipo = tipo;
         this.etaConsigliata = etaConsigliata;
         this.orariApertura = orariApertura;
         this.serviziOfferti = serviziOfferti;
         this.contatti = contatti;
     }

 }

