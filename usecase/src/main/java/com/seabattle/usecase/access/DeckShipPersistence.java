package com.seabattle.usecase.access;

import com.seabattle.entities.dto.DeckShip;

import java.util.List;

public interface DeckShipPersistence {

    DeckShip save(List<String> coordinates);

    void update(DeckShip deckShip);
}
