package com.seabattle.persistence.hibernate;

import com.seabattle.persistence.hibernate.postgres.CoordinateRepository;
import com.seabattle.persistence.hibernate.postgres.DeckShipRepository;
import com.seabattle.usecase.access.CoordinateExtractor;
import com.seabattle.usecase.access.CoordinatePersistence;
import com.seabattle.usecase.access.DeckShipExtractor;
import com.seabattle.usecase.access.DeckShipPersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateBeanConfiguration {

    @Bean
    public CoordinateExtractor coordinateExtractor() {
        return new CoordinateRepository();
    }

    @Bean
    public CoordinatePersistence coordinatePersistence() {
        return new CoordinateRepository();
    }

    @Bean
    public DeckShipExtractor shipExtractor() {
        return new DeckShipRepository();
    }

    @Bean
    public DeckShipPersistence shipPersistence() {
        return new DeckShipRepository();
    }

}
