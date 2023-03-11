package com.seabattle.usecase.scenarios;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.entities.dto.DeckShip;
import com.seabattle.entities.rules.ship_build.DeckShipBuildingRule;
import com.seabattle.entities.rules.ship_build.exceptions.DeckShipBuildingException;
import com.seabattle.usecase.AddDeckShip;
import com.seabattle.usecase.access.CoordinateExtractor;
import com.seabattle.usecase.access.DeckShipExtractor;
import com.seabattle.usecase.access.DeckShipPersistence;

import java.util.List;

public class AddDeckShipUseCase implements AddDeckShip {

    private DeckShipPersistence shipPersistence;
    private DeckShipExtractor shipExtractor;
    private CoordinateExtractor coordinateExtractor;
    private DeckShipBuildingRule shipBuildingRule;
    private DeckShip deckShip;

    public AddDeckShipUseCase(DeckShipPersistence shipPersistence,
                              DeckShipExtractor shipExtractor,
                              CoordinateExtractor coordinateExtractor) {
        this.shipPersistence = shipPersistence;
        this.shipExtractor = shipExtractor;
        this.coordinateExtractor = coordinateExtractor;
//        this.shipBuildingRule = shipBuildingRule;
    }

    @Override
    public DeckShip execute(List<String> coordinates) throws DeckShipBuildingException {
        List<DeckShip> deckShips = shipExtractor.getAll();
        List<Coordinate> shipCoordinates = coordinateExtractor.getAll();

        if (shipBuildingRule.canBuild(coordinates, deckShips, shipCoordinates)) {
            deckShip = shipPersistence.save(coordinates);
        }

        return deckShip;
    }
}
