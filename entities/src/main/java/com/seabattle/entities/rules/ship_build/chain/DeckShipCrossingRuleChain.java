package com.seabattle.entities.rules.ship_build.chain;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.entities.dto.DeckShip;
import com.seabattle.entities.rules.ship_build.exceptions.DeckShipBuildingException;
import com.seabattle.entities.rules.ship_build.exceptions.DeckShipCrossingException;

import java.util.*;

public class DeckShipCrossingRuleChain extends DeckShipBuildingRuleChain {

    private Set<String> coordinatesContent = new HashSet<>();

    @Override
    public boolean check(List<String> coordinates, List<DeckShip> deckShips, List<Coordinate> shipCoordinates) throws DeckShipBuildingException {
        boolean coordinateExists;

        for (Coordinate coordinate : shipCoordinates) {
            coordinatesContent.add(coordinate.getContent());
        }

        for (String coordinate : coordinates) {
            coordinateExists = coordinatesContent.contains(coordinate);

            if (coordinateExists) {
                throw new DeckShipCrossingException("Ships cannot cross");
            }

        }

        return checkNext(coordinates, deckShips, shipCoordinates);
    }
}
