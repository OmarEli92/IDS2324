package it.unicam.cs.observer;


import it.unicam.cs.model.Contest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface ContestObserver {

    void update(Integer idContest);
}
