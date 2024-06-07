package it.unicam.cs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "it.unicam.cs.repository")
@EntityScan(basePackages = {"it.unicam.cs.model","it.unicam.cs.security"})
public class AppValorizzazioneTerritorio {
    public static void main(String[] args) {
        SpringApplication.run(AppValorizzazioneTerritorio.class, args);
    }
}