package com.seabattle.entities.rules.ship_build.chain;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.entities.dto.DeckShip;
import com.seabattle.entities.rules.ship_build.exceptions.ShipIntegrityException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShipIntegrityRuleChainTest {

    ShipIntegrityRuleChain shipIntegrityRuleChain;
    List<DeckShip> deckShips;
    List<Coordinate> shipCoordinates;

    @BeforeEach
    void setup() {
        shipIntegrityRuleChain = new ShipIntegrityRuleChain();
        deckShips = List.of(new DeckShip(List.of(new Coordinate(""))));
        shipCoordinates = List.of(new Coordinate(""));
    }

    @Test
    void exceptionWillBeThrown() {
        List<String> coordinates = List.of("B2", "B3", "C2");

        assertThrows(ShipIntegrityException.class, () -> shipIntegrityRuleChain.check(coordinates, deckShips, shipCoordinates));
    }

}
