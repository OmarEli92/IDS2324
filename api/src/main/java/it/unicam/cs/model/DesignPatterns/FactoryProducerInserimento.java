package it.unicam.cs.model.DesignPatterns;

public class FactoryProducerInserimento {
    public static AbstractFactoryInserimento getFactory (boolean pending){
        if(!pending)
            return new InserimentoFactory();
        else
            return new InserimentoInPendingFactory();
    }
}
