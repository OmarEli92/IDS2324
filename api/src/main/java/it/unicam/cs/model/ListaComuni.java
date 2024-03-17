package it.unicam.cs.model;

import org.springframework.stereotype.Service;

import java.util.List;

/** Classe che gestirà la lista di tutti i comuni**/

@Service
public class ListaComuni {

    private static ListaComuni instance;
    private List<Comune> comuni;
    private List<Utente> gestoriComuni;

    private ListaComuni(List<Comune> comuni, List<Utente> gestoriComuni){
        this.comuni = comuni;
        this.gestoriComuni = gestoriComuni;
    }

    public static  ListaComuni getInstance(List<Comune> comuni, List<Utente> gestoriComuni) {
        if (instance == null) {
            instance = new ListaComuni(comuni, gestoriComuni);
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

