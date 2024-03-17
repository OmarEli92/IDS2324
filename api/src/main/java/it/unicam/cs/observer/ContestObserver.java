package it.unicam.cs.observer;


import it.unicam.cs.model.Contest;
import org.springframework.stereotype.Service;

@Service
public interface ContestObserver {
    void update(Contest contest);
}
