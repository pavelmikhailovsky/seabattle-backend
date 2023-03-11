package com.seabattle.entities.rules.hit;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.entities.dto.DeckShip;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeckShipDamageTest {

    DeckShipDamage deckShipDamage;
    DeckShip deckShip;

    @Test
    void successfulShipDamage() {
        List<Coordinate> shipCoordinates = List.of(new Coordinate("A1"), new Coordinate("A2"), new Coordinate("A3"));
        Coordinate damageCoordinate = new Coordinate("A2");

        deckShip = new DeckShip(new ArrayList<>(shipCoordinates));
        deckShipDamage = new DeckShipDamage();

        deckShipDamage.hit(deckShip, new Coordinate("A2"));
        DeckShip shipDeckAfterDamage = deckShip;
        Coordinate[] damageCoordinatesAfterDamage = shipDeckAfterDamage.getDamageCoordinates().toArray(new Coordinate[0]);

        assertArrayEquals(new Coordinate[] {damageCoordinate}, damageCoordinatesAfterDamage);
    }

}
