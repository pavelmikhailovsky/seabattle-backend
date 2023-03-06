package com.seabattle.application.configuration;

import com.seabattle.usecase.AddShip;
import com.seabattle.usecase.OpponentsMoveHistory;
import com.seabattle.usecase.YourMoveHistory;
import com.seabattle.usecase.access.CoordinateExtractor;
import com.seabattle.usecase.access.ShipExtractor;
import com.seabattle.usecase.access.ShipPersistence;
import com.seabattle.usecase.scenarios.AddShipUseCase;
import com.seabattle.usecase.scenarios.OpponentsMoveHistoryUseCase;
import com.seabattle.usecase.scenarios.YourMoveHistoryUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public AddShip addShip(ShipPersistence shipPersistence,
                           ShipExtractor shipExtractor,
                           CoordinateExtractor coordinateExtractor) {
        return new AddShipUseCase(shipPersistence, shipExtractor, coordinateExtractor);
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
