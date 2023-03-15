package com.seabattle.application.configuration;

import com.seabattle.entities.rules.ship_build.DeckShipBuildingRule;
import com.seabattle.usecase.AddDeckShip;
import com.seabattle.usecase.OpponentsMoveHistory;
import com.seabattle.usecase.YourMoveHistory;
import com.seabattle.usecase.access.CoordinateExtractor;
import com.seabattle.usecase.access.DeckShipExtractor;
import com.seabattle.usecase.access.DeckShipPersistence;
import com.seabattle.usecase.scenarios.AddDeckShipUseCase;
import com.seabattle.usecase.scenarios.OpponentsMoveHistoryUseCase;
import com.seabattle.usecase.scenarios.YourMoveHistoryUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public AddDeckShip addShip(DeckShipPersistence shipPersistence,
                               DeckShipExtractor shipExtractor,
                               CoordinateExtractor coordinateExtractor,
                               DeckShipBuildingRule deckShipBuildingRule) {
        return new AddDeckShipUseCase(shipPersistence, shipExtractor, coordinateExtractor, deckShipBuildingRule);
    }

    @Bean
    public OpponentsMoveHistory opponentsMoveHistory() {
        return new OpponentsMoveHistoryUseCase();
    }

    @Bean
    public YourMoveHistory yourMoveHistory(CoordinateExtractor coordinateExtractor) {
        return new YourMoveHistoryUseCase(coordinateExtractor);
    }

}
