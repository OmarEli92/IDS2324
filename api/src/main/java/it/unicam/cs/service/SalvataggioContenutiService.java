package it.unicam.cs.service;

import it.unicam.cs.repository.IPOIRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class SalvataggioContenutiService {
    private IPOIRepository poiRepository;

}
