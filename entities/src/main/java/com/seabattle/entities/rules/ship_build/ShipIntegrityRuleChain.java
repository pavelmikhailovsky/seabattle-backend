package com.seabattle.entities.rules.ship_build;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.entities.dto.DeckShip;
import com.seabattle.entities.rules.ship_build.exceptions.ShipBuildingException;
import com.seabattle.entities.rules.ship_build.exceptions.ShipIntegrityException;

import java.util.List;

public class ShipIntegrityRuleChain extends ShipBuildingRuleChain {

    private boolean isHorizontalOrderShipsFromLeftRight = true;
    private boolean isVerticalOrderShipsFromDownUp = true;

    @Override
    public boolean check(List<String> coordinates, List<DeckShip> deckShips, List<Coordinate> shipCoordinate) throws ShipBuildingException {

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

            isVerticalOrder = verticalOrder(currentCoordinate, pastCoordinate, i);
            pastCoordinate = currentCoordinate;
        }

        return checkNext(coordinates, deckShips, shipCoordinate);
    }

    private boolean horizontalOrder(String currentCoordinate, String pastCoordinate, int iterationNumber) {
        boolean isOrder = true;

        char currentLetter = currentCoordinate.charAt(0);
        int currentInteger = Integer.parseInt(currentCoordinate.substring(1));

        char pastLetter = pastCoordinate.charAt(0);
        int pastInteger = Integer.parseInt(pastCoordinate.substring(1));

        if (currentLetter != pastLetter) return false;

        if (isHorizontalOrderShipsFromLeftRight) {

            if (BOARD_MAX_INTEGER != pastInteger) {
                int nextRightInteger = pastInteger + 1;

                if (nextRightInteger != currentInteger) {

                    if (pastInteger - 1 == currentInteger && iterationNumber == 1) {
                        isHorizontalOrderShipsFromLeftRight = false;
                    } else {
                        isOrder = false;
                    }

                }

            } else if (pastInteger - 1 == currentInteger) {
                isHorizontalOrderShipsFromLeftRight = false;
            } else {
                isOrder = false;
            }

        }

        if (!isHorizontalOrderShipsFromLeftRight) {
            int leftCoordinateInt = pastInteger - 1;

            if (BOARD_MIN_INTEGER > leftCoordinateInt || leftCoordinateInt != currentInteger) {
                isOrder = false;
            }
        }

        return isOrder;
    }

    private boolean verticalOrder(String currentCoordinate, String pastCoordinate, int iterationNumber) {
        boolean isOrder = true;

        char currentLetter = currentCoordinate.charAt(0);
        int currentInteger = Integer.parseInt(currentCoordinate.substring(1));

        char pastLetter = pastCoordinate.charAt(0);
        int pastInteger = Integer.parseInt(pastCoordinate.substring(1));

        if (pastInteger != currentInteger) return false;

        if (isVerticalOrderShipsFromDownUp) {
            char nextUpLetter = (char) (pastLetter - 1);

                if (TOP_LETTER_BOARD_ASCII == pastLetter || nextUpLetter != currentLetter) {

                    if (iterationNumber > 1) {
                        isOrder = false;
                    } else {
                        isVerticalOrderShipsFromDownUp = false;

                    }

                }
        }

        if (!isVerticalOrderShipsFromDownUp) {
            char nextDownLetter = (char) (pastLetter + 1);

            if (BOTTOM_LETTER_BOARD_ASCII == pastLetter || nextDownLetter != currentLetter) {
                isOrder = false;
            }
        }

        return isOrder;
    }
}
