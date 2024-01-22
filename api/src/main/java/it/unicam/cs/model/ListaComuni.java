package it.unicam.cs.model;

import java.util.List;

/** Classe che gestirà la lista di tutti i comuni**/
public class ListaComuni {
    private final List<Comune> comuni;
    private final List<GestorePiattaforma> gestoriPiattaforma;

    public ListaComuni(List<Comune> comuni, List<GestorePiattaforma> gestoriPiattaforma){
        this.comuni = comuni;
        this.gestoriPiattaforma = gestoriPiattaforma;
    }

    public List<Comune> getComuni() {
        return comuni;
    }

    public Comune getComune(String nomeComune){
        for(Comune comune : comuni){
            if(comune.getNome().equals(nomeComune)){
                return comune;
            }
        }
        return null;
    }

}
