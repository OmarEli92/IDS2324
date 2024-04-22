package it.unicam.cs;

import it.unicam.cs.Factory.POI.DefaultPOIBuilderFactory;
import it.unicam.cs.Factory.POI.IPOIBuilderFactory;
import it.unicam.cs.Visitor.POI.IPOIBuilderVisitor;
import it.unicam.cs.Visitor.POI.IPoiDtoVisitor;
import it.unicam.cs.Visitor.POI.PoiBuilderVisitor;
import it.unicam.cs.Visitor.POI.PoiDtoVisitor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public IPOIBuilderFactory poiBuilderFactory() {
        return new DefaultPOIBuilderFactory();
    }
    @Bean
    public IPoiDtoVisitor poiDtoVisitor(){
        return new PoiDtoVisitor();
    }
    @Bean
    public IPOIBuilderVisitor poiBuilderVisitor(){
        return new PoiBuilderVisitor();
    }
}
