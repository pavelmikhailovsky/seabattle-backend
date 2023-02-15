package com.seabattle.entities.rules.ship_build.chain;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.entities.dto.DeckShip;
import com.seabattle.entities.rules.ship_build.exceptions.ShipBuildingException;
import com.seabattle.entities.rules.ship_build.exceptions.ShipCrossingException;

import java.util.*;

public class ShipCrossingRuleChain extends ShipBuildingRuleChain {

    private Set<String> coordinatesContent = new HashSet<>();

    @Override
    public boolean check(List<String> coordinates, List<DeckShip> deckShips, List<Coordinate> shipCoordinate) throws ShipBuildingException {
        boolean coordinateExists;

        for (Coordinate coordinate : shipCoordinate) {
            coordinatesContent.add(coordinate.getContent());
        }

        for (String coordinate : coordinates) {
            coordinateExists = coordinatesContent.contains(coordinate);

            if (coordinateExists) {
                throw new ShipCrossingException("Ships cannot cross");
            }

        }

        return checkNext(coordinates, deckShips, shipCoordinate);
    }
}
