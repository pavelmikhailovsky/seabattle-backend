package com.seabattle.persistence.hibernate.postgres;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.entities.dto.DeckShip;
import com.seabattle.usecase.access.DeckShipExtractor;
import com.seabattle.usecase.access.DeckShipPersistence;

import java.util.List;

public class DeckShipRepository implements DeckShipPersistence, DeckShipExtractor {

    @Override
    public List<DeckShip> getAll() {
        return null;
    }

    @Override
    public DeckShip save(List<Coordinate> coordinates) {
        return null;
    }

    @Override
    public void update(DeckShip deckShip) {

    }
}
