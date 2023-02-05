package com.seabattle.entities.rules.build;

import java.util.List;

public interface ShipBuilding {

    boolean canBuild(List<String> coordinates, List<DeckShip> deckShips, List<Coordinate> shipCoordinate);
}
