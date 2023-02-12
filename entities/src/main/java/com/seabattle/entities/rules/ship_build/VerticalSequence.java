package com.seabattle.entities.rules.ship_build;

public class VerticalSequence extends Sequence {

    private boolean isVerticalOrderShipsFromDownUp = true;

    @Override
    public boolean check(String currentCoordinate, String pastCoordinate, int iterationNumber) {
        isSequence = true;
        splitCoordinateLetter(currentCoordinate, pastCoordinate);
        splitCoordinateInteger(currentCoordinate, pastCoordinate);

        if (pastInteger != currentInteger) return false;

        if (isVerticalOrderShipsFromDownUp) {
            char nextUpLetter = (char) (pastLetter - 1);

            if (Board.TOP_LETTER_ASCII.getI() == pastLetter || nextUpLetter != currentLetter) {

                if (iterationNumber > 1) {
                    isSequence = false;
                } else {
                    isVerticalOrderShipsFromDownUp = false;
                }

            }
        }

        if (!isVerticalOrderShipsFromDownUp) {
            char nextDownLetter = (char) (pastLetter + 1);

            if (Board.BOTTOM_LETTER_ASCII.getI() == pastLetter || nextDownLetter != currentLetter) {
                isSequence = false;
            }
        }

        return isSequence;

    }
}
