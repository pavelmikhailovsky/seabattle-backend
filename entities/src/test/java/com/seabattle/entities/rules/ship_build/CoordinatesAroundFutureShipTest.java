package com.seabattle.entities.rules.ship_build;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatesAroundFutureShipTest {

    private CoordinatesAroundFutureShip coordinatesAroundFutureShip;

    @Test
    void definingCoordinatesForCornerCoordinateItself() {
        List<String> coordinates = List.of("A1");
        coordinatesAroundFutureShip = new CoordinatesAroundFutureShip(coordinates);

        Set<String> returnCoordinates = Set.of("B2", "A2", "B1");
        Set<String> actual = coordinatesAroundFutureShip.determinate();

        assertEquals(returnCoordinates, actual);
    }

    @Test
    void determiningCoordinatesForTopmostHorizontalCoordinates() {
        List<String> coordinates = List.of("A2");
        coordinatesAroundFutureShip = new CoordinatesAroundFutureShip(coordinates);

        Set<String> returnCoordinates = Set.of("A1", "A3", "B1", "B2", "B3");
        Set<String> actual = coordinatesAroundFutureShip.determinate();

        assertEquals(returnCoordinates, actual);
    }

    @Test
    void determiningCoordinatesForLowestHorizontalCoordinates() {
        List<String> coordinates = List.of("J2");
        coordinatesAroundFutureShip = new CoordinatesAroundFutureShip(coordinates);

        Set<String> returnCoordinates = Set.of("J1", "J3", "I1", "I2", "I3");
        Set<String> actual = coordinatesAroundFutureShip.determinate();

        assertEquals(returnCoordinates, actual);
    }

    @Test
    void determiningCoordinatesForLeftmostVerticalCoordinates() {
        List<String> coordinates = List.of("B1");
        coordinatesAroundFutureShip = new CoordinatesAroundFutureShip(coordinates);

        Set<String> returnCoordinates = Set.of("A1", "C1", "A2", "B2", "C2");
        Set<String> actual = coordinatesAroundFutureShip.determinate();

        assertEquals(returnCoordinates, actual);
    }

    @Test
    void determiningCoordinatesForRightmostVerticalCoordinates() {
        List<String> coordinates = List.of("B10");
        coordinatesAroundFutureShip = new CoordinatesAroundFutureShip(coordinates);

        Set<String> returnCoordinates = Set.of("A10", "C10", "A9", "B9", "C9");
        Set<String> actual = coordinatesAroundFutureShip.determinate();

        assertEquals(returnCoordinates, actual);
    }

    @Test
    void definingCoordinatesForCoordinatesInMiddle() {
        List<String> coordinates = List.of("B2");
        coordinatesAroundFutureShip = new CoordinatesAroundFutureShip(coordinates);

        Set<String> returnCoordinates = Set.of("A1", "A2", "A3", "B1", "B3", "C1", "C2", "C3");
        Set<String> actual = coordinatesAroundFutureShip.determinate();

        assertEquals(returnCoordinates, actual);
    }
}
