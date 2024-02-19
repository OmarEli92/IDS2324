package it.unicam.cs.model.DesignPatterns;

import it.unicam.cs.model.*;

public class InserimentoFactory extends AbstractFactoryInserimento {
    @Override
    public Inserimento getInserimento(Contenuto tipo) {
        if(tipo instanceof POI)
            return new InserimentoPOI();
        if(tipo instanceof Evento)
            return new InserimentoEvento();
        if(tipo instanceof Itinerario )
            return new InserimentoItinerario();
        else if (tipo instanceof ContenutoMultimediale) {
            return new InserimentoContenutoMultimediale();
        }
        return null;
    }
}
