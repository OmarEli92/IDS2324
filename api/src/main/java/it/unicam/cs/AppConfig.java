package it.unicam.cs;

import it.unicam.cs.Factory.POI.DefaultPOIBuilderFactory;
import it.unicam.cs.Factory.POI.IPOIBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public IPOIBuilderFactory poiBuilderFactory() {
        return new DefaultPOIBuilderFactory();
    }
}
