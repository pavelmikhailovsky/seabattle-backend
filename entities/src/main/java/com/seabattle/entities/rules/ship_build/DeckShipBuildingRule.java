package com.seabattle.entities.rules.ship_build;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.entities.dto.DeckShip;
import com.seabattle.entities.rules.ship_build.exceptions.DeckShipBuildingException;

import java.util.List;

public interface DeckShipBuildingRule {

    boolean canBuild(List<String> coordinates, List<DeckShip> deckShips, List<Coordinate> shipCoordinates) throws DeckShipBuildingException;
}
