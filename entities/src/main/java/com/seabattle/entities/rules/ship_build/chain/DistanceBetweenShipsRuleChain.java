package com.seabattle.entities.rules.ship_build.chain;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.entities.dto.DeckShip;
import com.seabattle.entities.rules.ship_build.Board;
import com.seabattle.entities.rules.ship_build.CoordinatesAroundFutureShip;
import com.seabattle.entities.rules.ship_build.exceptions.DistanceBetweenShipsException;
import com.seabattle.entities.rules.ship_build.exceptions.ShipBuildingException;

import java.util.List;
import java.util.Set;

public class DistanceBetweenShipsRuleChain extends ShipBuildingRuleChain {

    private CoordinatesAroundFutureShip coordinatesAroundFutureShip;
    private Set<String> coordinatesAroundShip;

    public DistanceBetweenShipsRuleChain(CoordinatesAroundFutureShip coordinatesAroundFutureShip) {
        this.coordinatesAroundFutureShip = coordinatesAroundFutureShip;
    }

    @Override
    public boolean check(List<String> coordinates, List<DeckShip> deckShips, List<Coordinate> shipCoordinate) throws ShipBuildingException {
        coordinatesAroundShip = coordinatesAroundFutureShip.determinate();

        for (Coordinate coordinate : shipCoordinate) {
            boolean isCoordinateExists = coordinatesAroundShip.contains(coordinate.getContent());

            if (isCoordinateExists) {
                String messageException = String.format(
                        "Distance between ships must be at least %s coordinate",
                        Board.DISTANCE_BETWEEN_SHIPS.getI());
                throw new DistanceBetweenShipsException(messageException);
            }
        }

        return checkNext(coordinates, deckShips, shipCoordinate);
    }

}
