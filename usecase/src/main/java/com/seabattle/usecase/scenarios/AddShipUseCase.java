package com.seabattle.usecase.scenarios;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.entities.dto.DeckShip;
import com.seabattle.entities.rules.ship_build.ShipBuildingRule;
import com.seabattle.entities.rules.ship_build.exceptions.ShipBuildingException;
import com.seabattle.usecase.AddShip;
import com.seabattle.usecase.access.CoordinateExtractor;
import com.seabattle.usecase.access.ShipExtractor;
import com.seabattle.usecase.access.ShipPersistence;

import java.util.List;

public class AddShipUseCase implements AddShip {

    private ShipPersistence shipPersistence;
    private ShipExtractor shipExtractor;
    private CoordinateExtractor coordinateExtractor;
    private ShipBuildingRule shipBuildingRule;
    private DeckShip deckShip;

    public AddShipUseCase(ShipPersistence shipPersistence,
                          ShipExtractor shipExtractor,
                          CoordinateExtractor coordinateExtractor) {
        this.shipPersistence = shipPersistence;
        this.shipExtractor = shipExtractor;
        this.coordinateExtractor = coordinateExtractor;
//        this.shipBuildingRule = shipBuildingRule;
    }

    @Override
    public DeckShip execute(List<String> coordinates) throws ShipBuildingException {
        List<DeckShip> deckShips = shipExtractor.getAll();
        List<Coordinate> shipCoordinates = coordinateExtractor.getAll();

        if (shipBuildingRule.canBuild(coordinates, deckShips, shipCoordinates)) {
            deckShip = shipPersistence.save(coordinates);
        }

        return deckShip;
    }
}
