package com.seabattle.entities.rules.ship_build;

import com.seabattle.entities.rules.ship_build.exceptions.ShipBuildingException;

import java.util.List;

public class ShipCrossingRuleChain extends ShipBuildingRuleChain {
    @Override
    public boolean check(List<String> coordinates, List<DeckShip> deckShips, List<Coordinate> shipCoordinate) throws ShipBuildingException {
        return false;
    }
}
