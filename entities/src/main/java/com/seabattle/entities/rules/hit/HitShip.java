package com.seabattle.entities.rules.hit;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.entities.dto.DeckShip;

public interface HitShip {

    void hit(DeckShip deckShip, Coordinate shipCoordinate);
}
