package com.seabattle.entities.rules.ship_build.chain;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.entities.dto.DeckShip;
import com.seabattle.entities.rules.ship_build.exceptions.ShipCrossingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShipCrossingRuleChainTest {

    ShipCrossingRuleChain shipCrossingRuleChain;
    List<Coordinate> shipCoordinates;
    List<DeckShip> deckShips;

    @BeforeEach
    void setup() {
        shipCrossingRuleChain = new ShipCrossingRuleChain();
        deckShips = List.of(new DeckShip(List.of(new Coordinate("")), List.of(new Coordinate(""))));
    }

    @Test
    void exceptionWillBeThrownIfShipWithThisCoordinateAlreadyBeenCreated() {
        List<String> coordinates = List.of("A1", "B1", "C1");
        shipCoordinates = List.of(
                new Coordinate("J8"),
                new Coordinate("J9"),
                new Coordinate("J10"),
                new Coordinate("A1"),
                new Coordinate("C2"));

        assertThrows(ShipCrossingException.class, () -> shipCrossingRuleChain.check(coordinates, deckShips, shipCoordinates));
    }

}
