package com.seabattle.entities.rules.ship_build;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.entities.dto.DeckShip;
import com.seabattle.entities.rules.ship_build.exceptions.ShipIntegrityException;

import java.util.List;

public class ShipIntegrityRuleChain extends ShipBuildingRuleChain {

    private boolean isHorizontalOrderShipsFromLeftRight = true;
    private boolean isVerticalOrderShipsFromDownUp = true;

    @Override
    public boolean check(List<String> coordinates, List<DeckShip> deckShips, List<Coordinate> shipCoordinate) throws ShipIntegrityException{

        String pastCoordinate = coordinates.stream().findFirst().get();
        String currentCoordinate;
        boolean isHorizontalOrder = true;
        boolean isVerticalOrder = true;


        for (int i = 1; i <= coordinates.size() - 1; i++) {
            currentCoordinate = coordinates.get(i);

            if (isHorizontalOrder) {
                isHorizontalOrder = horizontalOrder(currentCoordinate, pastCoordinate, i);
                pastCoordinate = currentCoordinate;

                if (!isHorizontalOrder) {
                    i = 0;
                    pastCoordinate = coordinates.stream().findFirst().get();
                }

                continue;
            }

            if (!isHorizontalOrder && !isVerticalOrder) {
                throw new ShipIntegrityException("The ship must be positioned vertically or horizontally");
            }

            isVerticalOrder = verticalOrder(currentCoordinate, pastCoordinate);
            pastCoordinate = currentCoordinate;
        }

        return checkNext(coordinates, deckShips, shipCoordinate);
    }

    private boolean horizontalOrder(String currentCoordinate, String pastCoordinate, int iterationNumber) {
        boolean isOrder = true;

        char currentLetter = currentCoordinate.charAt(0);
        String currentInteger = currentCoordinate.substring(1);

        char pastLetter = pastCoordinate.charAt(0);
        String pastInteger = pastCoordinate.substring(1);

        if (currentLetter != pastLetter) return false;

        if (isHorizontalOrderShipsFromLeftRight) {

            if (BOARD_MAX_INTEGER != Integer.parseInt(pastInteger)) {
                int nextLeftInteger = Integer.parseInt(pastInteger) + 1;

                if(nextLeftInteger != Integer.parseInt(currentInteger)) {

                    if (Integer.parseInt(pastInteger) - 1 == Integer.parseInt(currentInteger) && iterationNumber == 1) {
                        isHorizontalOrderShipsFromLeftRight = false;
                    } else {
                        isOrder = false;
                    }

                }

            } else if (Integer.parseInt(pastInteger) - 1 == Integer.parseInt(currentInteger)) {
                isHorizontalOrderShipsFromLeftRight = false;
            } else {
                isOrder = false;
            }

        }

        if (!isHorizontalOrderShipsFromLeftRight) {
            int leftCoordinateInt = Integer.parseInt(pastInteger) - 1;

        }

        return isOrder;
    }

    private boolean verticalOrder(String currentCoordinate, String pastCoordinate) {
        return false;
    }
}
