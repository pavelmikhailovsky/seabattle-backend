package com.seabattle.entities.rules.ship_build.chain;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.entities.dto.DeckShip;
import com.seabattle.entities.rules.ship_build.Board;
import com.seabattle.entities.rules.ship_build.CoordinatesAroundFutureShip;
import com.seabattle.entities.rules.ship_build.exceptions.DistanceBetweenDeckShipsException;
import com.seabattle.entities.rules.ship_build.exceptions.DeckShipBuildingException;

import java.util.List;
import java.util.Set;

public class DistanceBetweenDeckShipsRuleChain extends DeckShipBuildingRuleChain {

    private CoordinatesAroundFutureShip coordinatesAroundFutureShip;
    private Set<String> coordinatesAroundShip;

    public DistanceBetweenDeckShipsRuleChain(CoordinatesAroundFutureShip coordinatesAroundFutureShip) {
        this.coordinatesAroundFutureShip = coordinatesAroundFutureShip;
    }

    @Override
    public boolean check(List<String> coordinates, List<DeckShip> deckShips, List<Coordinate> shipCoordinates) throws DeckShipBuildingException {
        coordinatesAroundShip = coordinatesAroundFutureShip.determinate();

        for (Coordinate coordinate : shipCoordinates) {
            boolean isCoordinateExists = coordinatesAroundShip.contains(coordinate.getContent());

            if (isCoordinateExists) {
                String messageException = String.format(
                        "Distance between ships must be at least %s coordinate",
                        Board.DISTANCE_BETWEEN_SHIPS.getI());
                throw new DistanceBetweenDeckShipsException(messageException);
            }
        }

        return checkNext(coordinates, deckShips, shipCoordinates);
    }

}
