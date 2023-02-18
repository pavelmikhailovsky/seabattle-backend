package com.seabattle.entities.rules.ship_build.chain;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.entities.dto.DeckShip;
import com.seabattle.entities.rules.ship_build.Board;
import com.seabattle.entities.rules.ship_build.exceptions.DistanceBetweenShipsException;
import com.seabattle.entities.rules.ship_build.exceptions.ShipBuildingException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DistanceBetweenShipsRuleChain extends ShipBuildingRuleChain {

    private Set<String> coordinatesAroundFutureShip;

    @Override
    public boolean check(List<String> coordinates, List<DeckShip> deckShips, List<Coordinate> shipCoordinate) throws ShipBuildingException {
        coordinatesAroundFutureShip = determinateCoordinatesAroundFutureShip(coordinates);

        for (Coordinate coordinate : shipCoordinate) {
            boolean isCoordinateExists = coordinatesAroundFutureShip.contains(coordinate.getContent());

            if (isCoordinateExists) {
                String messageException = String.format(
                        "Distance between ships must be at least %s coordinate",
                        Board.DISTANCE_BETWEEN_SHIPS.getI());
                throw new DistanceBetweenShipsException(messageException);
            }
        }

        return checkNext(coordinates, deckShips, shipCoordinate);
    }

    private Set<String> determinateCoordinatesAroundFutureShip(List<String> shipCoordinates) {
        Set<String> coordinatesAroundShip = new HashSet<>();

        for (String shipCoordinate : shipCoordinates) {
            char coordinateLetter = shipCoordinate.charAt(0);
            int coordinateNumber = Integer.parseInt(shipCoordinate.substring(1));

            if (oneGroup(shipCoordinate)) {
                //do something
            } else if(twoGroup(coordinateLetter)) {
                //do something
            } else if(threeGroup(coordinateLetter)) {
                //do something
            } else if(fourGroup(coordinateNumber)) {
                //do something
            } else if(fiveGroup(coordinateNumber)) {
                //do something
            } else {
                //do something, six group (B2 - B9 etc)
            }
        }

        return coordinatesAroundShip;
    }

    private boolean oneGroup(String coordinate) {
        String topLeftCoordinate = String.format(
                "%s%s",
                Board.MARKUP_TOP_LETTER_ASCII.getI(), Board.MARKUP_MIN_INTEGER.getI());
        String bottomLeftCoordinate = String.format(
                "%s%s",
                Board.MARKUP_BOTTOM_LETTER_ASCII.getI(), Board.MARKUP_MIN_INTEGER.getI());
        String topRightCoordinate = String.format(
                "%s%s",
                Board.MARKUP_TOP_LETTER_ASCII.getI(), Board.MARKUP_MAX_INTEGER.getI());
        String bottomRightCoordinate = String.format(
                "%s%s",
                Board.MARKUP_BOTTOM_LETTER_ASCII.getI(), Board.MARKUP_MAX_INTEGER.getI());

        if (coordinate.equals(topLeftCoordinate) || coordinate.equals(bottomLeftCoordinate)
                || coordinate.equals(topRightCoordinate) || coordinate.equals(bottomRightCoordinate)) {
            return true;
        }

        return false;
    }

    private boolean twoGroup(char coordinateLetter) {
        if (coordinateLetter == Board.MARKUP_TOP_LETTER_ASCII.getI()) {
            return true;
        }
        return false;
    }

    private boolean threeGroup(char coordinateLetter) {
        if (coordinateLetter == Board.MARKUP_BOTTOM_LETTER_ASCII.getI()) {
            return true;
        }
        return false;
    }

    private boolean fourGroup(int coordinateNumber) {
        if (coordinateNumber == Board.MARKUP_MIN_INTEGER.getI()) {
            return true;
        }
        return false;
    }

    private boolean fiveGroup(int coordinateNumber) {
        if (coordinateNumber == Board.MARKUP_MAX_INTEGER.getI()) {
            return true;
        }
        return false;
    }
}
