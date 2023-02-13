package com.seabattle.entities.rules.ship_build;

public class HorizontalSequence extends Sequence {

    private boolean isHorizontalSequenceShipsFromLeftRight = true;

    @Override
    public boolean check(String currentCoordinate, String pastCoordinate, int iterationNumber) {
        isSequence = true;
        splitCoordinateLetter(currentCoordinate, pastCoordinate);
        splitCoordinateInteger(currentCoordinate, pastCoordinate);

        if (currentLetter != pastLetter) return false;

        if (isHorizontalSequenceShipsFromLeftRight) {

            if (Board.MAX_INTEGER.getI() != pastInteger) {
                int nextRightInteger = pastInteger + 1;

                if (nextRightInteger != currentInteger) {

                    if (pastInteger - 1 == currentInteger && iterationNumber == 1) {
                        isHorizontalSequenceShipsFromLeftRight = false;
                    } else {
                        isSequence = false;
                    }

                }

            } else if (pastInteger - 1 == currentInteger) {
                isHorizontalSequenceShipsFromLeftRight = false;
            } else {
                isSequence = false;
            }
        }

        if (!isHorizontalSequenceShipsFromLeftRight) {
            int leftCoordinateInt = pastInteger - 1;

            if (Board.MIN_INTEGER.getI() > leftCoordinateInt || leftCoordinateInt != currentInteger) {
                isSequence = false;
            }
        }

        return isSequence;
    }
}
