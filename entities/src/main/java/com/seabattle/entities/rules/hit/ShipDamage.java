package com.seabattle.entities.rules.hit;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.entities.dto.DeckShip;

import java.util.List;

public class ShipDamage implements HitShip {

    private DeckShip deckShip;
    private final boolean IS_SHIP_SANK = true;
    private List<Coordinate> damageCoordinates;
    private List<Coordinate> coordinates;

    public ShipDamage(DeckShip deckShip) {
        this.deckShip = deckShip;
    }

    @Override
    public DeckShip hit(Coordinate shipCoordinate) {
        damageCoordinates = deckShip.getDamageCoordinates();
        coordinates = deckShip.getCoordinates();

        coordinates.remove(shipCoordinate);
        deckShip.setCoordinates(coordinates);

        damageCoordinates.add(shipCoordinate);
        deckShip.setDamageCoordinates(damageCoordinates);

        if (coordinates.isEmpty()) {
            deckShip.setSank(IS_SHIP_SANK);
        }

        return deckShip;
    }
}
