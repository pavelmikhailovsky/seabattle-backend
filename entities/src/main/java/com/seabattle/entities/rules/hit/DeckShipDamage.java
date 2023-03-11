package com.seabattle.entities.rules.hit;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.entities.dto.DeckShip;

import java.util.List;

public class DeckShipDamage implements HitDeckShip {

    private final boolean IS_SHIP_SANK = true;
    private List<Coordinate> damageCoordinates;
    private List<Coordinate> coordinates;

    @Override
    public void hit(DeckShip deckShip, Coordinate shipCoordinate) {
        damageCoordinates = deckShip.getDamageCoordinates();
        coordinates = deckShip.getCoordinates();

        coordinates.remove(shipCoordinate);
        deckShip.setCoordinates(coordinates);

        damageCoordinates.add(shipCoordinate);
        deckShip.setDamageCoordinates(damageCoordinates);

        if (coordinates.isEmpty()) {
            deckShip.setSank(IS_SHIP_SANK);
        }

    }
}
