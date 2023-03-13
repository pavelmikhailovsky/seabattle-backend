package com.seabattle.entities.rules.ship_build.chain;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.entities.dto.DeckShip;
import com.seabattle.entities.rules.ship_build.exceptions.NumberDeckShipsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class NumberDeckShipsRuleChainTest {

    NumberDeckShipsRuleChain numberShipsRuleChain;
    List<DeckShip> deckShips;
    List<Coordinate> shipCoordinates;

    @BeforeEach
    void setup() {
        numberShipsRuleChain = new NumberDeckShipsRuleChain();
        deckShips = List.of(
                new DeckShip(UUID.randomUUID(), List.of(new Coordinate("B1"), new Coordinate("B2"))),
                new DeckShip(UUID.randomUUID(), List.of(new Coordinate("C1"), new Coordinate("C2"))),
                new DeckShip(UUID.randomUUID(), List.of(new Coordinate("D1"), new Coordinate("D2"))));
        shipCoordinates = List.of(new Coordinate(""));
    }

    @Test
    void exceptionWillBeThrownIfNumberOfShipDecksExceeded() {
        List<String> coordinates = List.of("A1", "A2", "A3", "A4", "A5");

        assertThrows(NumberDeckShipsException.class, () -> numberShipsRuleChain.check(coordinates, deckShips, shipCoordinates));
    }

    @Test
    void exceptionWillBeThrownIfNotPossibleAddAnotherShip() {
        List<String> coordinates = List.of("A1", "A2");

        assertThrows(NumberDeckShipsException.class, () -> numberShipsRuleChain.check(coordinates, deckShips, shipCoordinates));
    }

}
