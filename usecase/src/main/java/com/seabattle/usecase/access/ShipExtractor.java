package com.seabattle.usecase.access;

import com.seabattle.entities.dto.DeckShip;

import java.util.List;

public interface ShipExtractor {

    List<DeckShip> getAll();

}
