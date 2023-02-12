package com.seabattle.entities.rules.ship_build;

public abstract class Sequence {

    protected boolean isSequence;

    protected int currentInteger;
    protected int pastInteger;

    protected char currentLetter;
    protected char pastLetter;

    public abstract boolean check(String currentCoordinate, String pastCoordinate, int iterationNumber);

    protected void splitCoordinateLetter(String currentCoordinate, String pastCoordinate) {
        currentLetter = currentCoordinate.charAt(0);
        pastLetter = pastCoordinate.charAt(0);
    }

    protected void splitCoordinateInteger(String currentCoordinate, String pastCoordinate) {
        currentInteger = Integer.parseInt(currentCoordinate.substring(1));
        pastInteger = Integer.parseInt(pastCoordinate.substring(1));
    }

}
