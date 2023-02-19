package com.seabattle.entities.rules.ship_build;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CoordinatesAroundFutureShip {

    private List<String> coordinates;
    private Set<String> coordinatesAroundShip = new HashSet<>();

    private static final String TOP_LEFT_COORDINATE = String.format(
            "%s%s",
            Board.MARKUP_TOP_LETTER_ASCII.getI(), Board.MARKUP_MIN_INTEGER.getI());
    private static final String BOTTOM_LEFT_COORDINATE = String.format(
            "%s%s",
            Board.MARKUP_BOTTOM_LETTER_ASCII.getI(), Board.MARKUP_MIN_INTEGER.getI());
    private static final String TOP_RIGHT_COORDINATE = String.format(
            "%s%s",
            Board.MARKUP_TOP_LETTER_ASCII.getI(), Board.MARKUP_MAX_INTEGER.getI());
    private static final String BOTTOM_RIGHT_COORDINATE = String.format(
            "%s%s",
            Board.MARKUP_BOTTOM_LETTER_ASCII.getI(), Board.MARKUP_MAX_INTEGER.getI());

    public CoordinatesAroundFutureShip(List<String> coordinates) {
        this.coordinates = coordinates;
    }

    public Set<String> determinate() {

        for (String shipCoordinate : coordinates) {
            char coordinateLetter = shipCoordinate.charAt(0);
            int coordinateNumber = Integer.parseInt(shipCoordinate.substring(1));

            if (CoordinateGroups.mostAngular(shipCoordinate)) {

                if (shipCoordinate.equals(TOP_LEFT_COORDINATE)) {

                    coordinatesAroundShip.add(String.format("%s%s", coordinateLetter + 1, coordinateNumber));
                    coordinatesAroundShip.add(String.format("%s%s", coordinateLetter, coordinateNumber + 1));
                    coordinatesAroundShip.add(String.format("%s%s", coordinateLetter + 1, coordinateNumber + 1));

                } else if (shipCoordinate.equals(BOTTOM_LEFT_COORDINATE)) {

                    coordinatesAroundShip.add(String.format("%s%s", coordinateLetter - 1, coordinateNumber));
                    coordinatesAroundShip.add(String.format("%s%s", coordinateLetter, coordinateNumber + 1));
                    coordinatesAroundShip.add(String.format("%s%s", coordinateLetter - 1, coordinateNumber + 1));

                } else if (shipCoordinate.equals(TOP_RIGHT_COORDINATE)) {

                    coordinatesAroundShip.add(String.format("%s%s", coordinateLetter + 1, coordinateNumber));
                    coordinatesAroundShip.add(String.format("%s%s", coordinateLetter, coordinateNumber - 1));
                    coordinatesAroundShip.add(String.format("%s%s", coordinateLetter + 1, coordinateNumber - 1));

                } else if (shipCoordinate.equals(BOTTOM_RIGHT_COORDINATE)) {

                    coordinatesAroundShip.add(String.format("%s%s", coordinateLetter - 1, coordinateNumber));
                    coordinatesAroundShip.add(String.format("%s%s", coordinateLetter, coordinateNumber - 1));
                    coordinatesAroundShip.add(String.format("%s%s", coordinateLetter - 1, coordinateNumber - 1));

                }

            } else if(CoordinateGroups.topmostHorizontal(coordinateLetter)) {

                creatingHorizontalCoordinates(coordinateLetter, coordinateNumber);
                creatingCoordinatesBelowCurrentOne(coordinateLetter, coordinateNumber);

            } else if(CoordinateGroups.lowestHorizontal(coordinateLetter)) {

                creatingHorizontalCoordinates(coordinateLetter, coordinateNumber);
                creatingCoordinatesAboveCurrentOne(coordinateLetter, coordinateNumber);

            } else if(CoordinateGroups.leftmostVertical(coordinateNumber)) {

                creatingVerticalCoordinates(coordinateLetter, coordinateNumber);
                creatingVerticalCoordinatesRightCurrentOne(coordinateLetter, coordinateNumber);

            } else if(CoordinateGroups.rightmostVertical(coordinateNumber)) {

                creatingVerticalCoordinates(coordinateLetter, coordinateNumber);
                creatingVerticalCoordinatesLeftCurrentOne(coordinateLetter, coordinateNumber);

            } else {

                creatingHorizontalCoordinates(coordinateLetter, coordinateNumber);
                creatingCoordinatesBelowCurrentOne(coordinateLetter, coordinateNumber);
                creatingCoordinatesAboveCurrentOne(coordinateLetter, coordinateNumber);

            }
        }

        return coordinatesAroundShip;
    }

    private void creatingHorizontalCoordinates(char coordinateLetter, int coordinateNumber) {
        coordinatesAroundShip.add(String.format("%s%s", coordinateLetter, coordinateNumber - 1));
        coordinatesAroundShip.add(String.format("%s%s", coordinateLetter, coordinateNumber + 1));
    }

    private void creatingVerticalCoordinates(char coordinateLetter, int coordinateNumber) {
        coordinatesAroundShip.add(String.format("%s%s", coordinateLetter - 1, coordinateNumber));
        coordinatesAroundShip.add(String.format("%s%s", coordinateLetter + 1, coordinateNumber));
    }

    private void creatingCoordinatesBelowCurrentOne(char coordinateLetter, int coordinateNumber) {
        coordinatesAroundShip.add(String.format("%s%s", coordinateLetter + 1, coordinateNumber - 1));
        coordinatesAroundShip.add(String.format("%s%s", coordinateLetter + 1, coordinateNumber));
        coordinatesAroundShip.add(String.format("%s%s", coordinateLetter + 1, coordinateNumber + 1));
    }

    private void creatingCoordinatesAboveCurrentOne(char coordinateLetter, int coordinateNumber) {
        coordinatesAroundShip.add(String.format("%s%s", coordinateLetter - 1, coordinateNumber - 1));
        coordinatesAroundShip.add(String.format("%s%s", coordinateLetter - 1, coordinateNumber));
        coordinatesAroundShip.add(String.format("%s%s", coordinateLetter - 1, coordinateNumber + 1));
    }

    private void creatingVerticalCoordinatesRightCurrentOne(char coordinateLetter, int coordinateNumber) {
        coordinatesAroundShip.add(String.format("%s%s", coordinateLetter - 1, coordinateNumber + 1));
        coordinatesAroundShip.add(String.format("%s%s", coordinateLetter, coordinateNumber + 1));
        coordinatesAroundShip.add(String.format("%s%s", coordinateLetter + 1, coordinateNumber + 1));
    }

    private void creatingVerticalCoordinatesLeftCurrentOne(char coordinateLetter, int coordinateNumber) {
        coordinatesAroundShip.add(String.format("%s%s", coordinateLetter - 1, coordinateNumber - 1));
        coordinatesAroundShip.add(String.format("%s%s", coordinateLetter, coordinateNumber - 1));
        coordinatesAroundShip.add(String.format("%s%s", coordinateLetter + 1, coordinateNumber - 1));
    }

    private static class CoordinateGroups {

        static boolean mostAngular(String coordinate) {
            if (coordinate.equals(TOP_LEFT_COORDINATE) || coordinate.equals(BOTTOM_LEFT_COORDINATE)
                    || coordinate.equals(TOP_RIGHT_COORDINATE) || coordinate.equals(BOTTOM_RIGHT_COORDINATE)) {
                return true;
            }

            return false;
        }

        static boolean topmostHorizontal(char coordinateLetter) {
            return coordinateLetter == Board.MARKUP_TOP_LETTER_ASCII.getI();
        }

        static boolean lowestHorizontal(char coordinateLetter) {
            return coordinateLetter == Board.MARKUP_BOTTOM_LETTER_ASCII.getI();
        }

        static boolean leftmostVertical(int coordinateNumber) {
            return coordinateNumber == Board.MARKUP_MIN_INTEGER.getI();
        }

        static boolean rightmostVertical(int coordinateNumber) {
            return coordinateNumber == Board.MARKUP_MAX_INTEGER.getI();
        }
    }
}
