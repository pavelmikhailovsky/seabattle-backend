package com.seabattle.usecase.access;

import com.seabattle.entities.dto.DeckShip;

public interface ShipPersistence {

    Long save(DeckShip deckShip);
}
