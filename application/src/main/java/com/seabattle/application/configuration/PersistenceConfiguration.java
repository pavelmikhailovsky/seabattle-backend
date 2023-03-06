package com.seabattle.application.configuration;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.entities.dto.DeckShip;
import com.seabattle.usecase.access.CoordinateExtractor;
import com.seabattle.usecase.access.CoordinatePersistence;
import com.seabattle.usecase.access.ShipExtractor;
import com.seabattle.usecase.access.ShipPersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PersistenceConfiguration {

    @Bean
    public CoordinateExtractor coordinateExtractor() {
        return new CoordinateExtractor() {
            @Override
            public List<Coordinate> getAll() {
                return null;
            }

            @Override
            public List<Coordinate> getAllMoves() {
                System.out.println("Call CoordinateExtractor");
                return null;
            }
        };
    }

    @Bean
    public CoordinatePersistence coordinatePersistence() {
        return new CoordinatePersistence() {
            @Override
            public String save(Coordinate coordinate) {
                return null;
            }
        };
    }

    @Bean
    public ShipExtractor shipExtractor() {
        return new ShipExtractor() {
            @Override
            public List<DeckShip> getAll() {
                return null;
            }
        };
    }

    @Bean
    public ShipPersistence shipPersistence() {
        return new ShipPersistence() {
            @Override
            public DeckShip save(List<String> coordinates) {
                return null;
            }

            @Override
            public void update(DeckShip deckShip) {

            }
        };
    }
}
