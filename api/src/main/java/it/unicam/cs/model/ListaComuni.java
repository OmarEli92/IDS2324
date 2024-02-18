package it.unicam.cs.model;

import it.unicam.cs.model.ruoli.GestorePiattaforma;
import org.springframework.stereotype.Service;

import java.util.List;

/** Classe che gestirà la lista di tutti i comuni**/

@Service
public class ListaComuni {

    private static ListaComuni instance;
    private List<Comune> comuni;
    private List<GestorePiattaforma> gestoriPiattaforma;

    private ListaComuni(List<Comune> comuni, List<GestorePiattaforma> gestoriPiattaforma){
        this.comuni = comuni;
        this.gestoriPiattaforma = gestoriPiattaforma;
    }

    public static  ListaComuni getInstance(List<Comune> comuni, List<GestorePiattaforma> gestoriPiattaforma) {
        if (instance == null) {
            instance = new ListaComuni(comuni, gestoriPiattaforma);
        }
        return instance;
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

