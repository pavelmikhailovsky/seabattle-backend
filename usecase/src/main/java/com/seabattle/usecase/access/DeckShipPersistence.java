package com.seabattle.usecase.access;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.entities.dto.DeckShip;

import java.util.List;

public interface DeckShipPersistence {

    DeckShip save(List<Coordinate> coordinates);

    void update(DeckShip deckShip);
}
