package it.unicam.cs.model.DesignPatterns;

import it.unicam.cs.model.*;

public class InserimentoInPendingFactory extends AbstractFactoryInserimento {
    @Override
    public Inserimento getInserimento(Contenuto tipo) {
        if(tipo instanceof POI)
            return new InserimentoPOIInPending();
        if(tipo instanceof Evento)
            return new InserimentoEventoInPending();
        if(tipo instanceof Itinerario)
            return new InserimentoItinerarioInPending();
        else if (tipo instanceof ContenutoMultimediale) {
            return new InserimentoContenutoMultimedialeInPending();
        }
        return null;
    }
}
