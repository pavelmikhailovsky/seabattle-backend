package com.seabattle.entities.rules.build;

import java.util.List;

public class DistanceBetweenShipsRuleChain extends ShipBuildingRuleChain {
    @Override
    public boolean check(List<String> coordinates, List<DeckShip> deckShips, List<Coordinate> shipCoordinate) {
        return false;
    }
}
