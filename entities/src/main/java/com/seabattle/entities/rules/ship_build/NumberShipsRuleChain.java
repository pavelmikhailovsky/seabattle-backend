package com.seabattle.entities.rules.ship_build;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.entities.dto.DeckShip;

import java.util.List;

public class NumberShipsRuleChain extends ShipBuildingRuleChain {
    @Override
    public boolean check(List<String> coordinates, List<DeckShip> deckShips, List<Coordinate> shipCoordinate) {
        return false;
    }
}
