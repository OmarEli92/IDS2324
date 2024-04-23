package it.unicam.cs;

import it.unicam.cs.Factory.Evento.DefaultEventoBuilderFactory;
import it.unicam.cs.Factory.Evento.IEventoBuilderFactory;
import it.unicam.cs.Factory.POI.DefaultPOIBuilderFactory;
import it.unicam.cs.Factory.POI.IPOIBuilderFactory;
import it.unicam.cs.Visitor.Evento.EventoBuilderVisitor;
import it.unicam.cs.Visitor.Evento.EventoDtoVisitor;
import it.unicam.cs.Visitor.Evento.IEventoBuilderVisitor;
import it.unicam.cs.Visitor.Evento.IEventoDtoVisitor;
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
    @Bean
    public IEventoBuilderFactory eventoBuilderFactory() { return new DefaultEventoBuilderFactory(); }
    @Bean
    public IEventoDtoVisitor eventoDtoVisitor() { return new EventoDtoVisitor(); }
    @Bean
    public IEventoBuilderVisitor eventoBuilderVisitor() { return new EventoBuilderVisitor(); }
}
