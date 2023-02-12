package com.seabattle.entities.rules.ship_build.chain;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.entities.dto.DeckShip;

import java.util.List;

public class ShipCrossingRuleChain extends ShipBuildingRuleChain {
    @Override
    public boolean check(List<String> coordinates, List<DeckShip> deckShips, List<Coordinate> shipCoordinate) {
        return false;
    }
}
