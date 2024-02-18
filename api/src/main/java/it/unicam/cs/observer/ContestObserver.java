package it.unicam.cs.observer;

import jakarta.persistence.Entity;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public interface ContestObserver {
    void update();
}
