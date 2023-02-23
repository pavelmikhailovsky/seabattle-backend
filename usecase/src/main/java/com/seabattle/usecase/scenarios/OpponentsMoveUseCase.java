package com.seabattle.usecase.scenarios;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.entities.dto.DeckShip;
import com.seabattle.entities.rules.hit.HitShip;
import com.seabattle.usecase.OpponentsMove;
import com.seabattle.usecase.Result;
import com.seabattle.usecase.access.CoordinateExtractor;
import com.seabattle.usecase.access.CoordinatePersistence;
import com.seabattle.usecase.access.ShipPersistence;
import com.seabattle.usecase.dto.ResultMove;

import java.util.List;

public class OpponentsMoveUseCase implements OpponentsMove {

    private CoordinateExtractor coordinateExtractor;
    private CoordinatePersistence coordinatePersistence;
    private ShipPersistence shipPersistence;
    private HitShip hitShip;

    public OpponentsMoveUseCase(CoordinateExtractor coordinateExtractor,
                                CoordinatePersistence coordinatePersistence,
                                ShipPersistence shipPersistence,
                                HitShip hitShip) {
        this.coordinateExtractor = coordinateExtractor;
        this.coordinatePersistence = coordinatePersistence;
        this.hitShip = hitShip;
        this.shipPersistence = shipPersistence;
    }

    @Override
    public ResultMove execute(String coordinate) {
        ResultMove executionResult = new ResultMove(coordinate, Result.MISS);
        List<Coordinate> shipCoordinates = coordinateExtractor.getAll();

        for (Coordinate shipCoordinate : shipCoordinates) {

            if (coordinate.equals(shipCoordinate.getContent())) {
                DeckShip deckShip = shipCoordinate.getShipLink();
                hitShip.hit(deckShip, shipCoordinate);

                executionResult = new ResultMove(coordinate, Result.HIT);
                shipPersistence.update(deckShip);

                break;
            }

        }

        return executionResult;
    }
}
