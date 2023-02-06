package com.seabattle.entities.rules.ship_build;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.entities.dto.DeckShip;
import com.seabattle.entities.rules.ship_build.exceptions.ShipBuildingException;

import java.util.List;

public class ShipCrossingRuleChain extends ShipBuildingRuleChain {
    @Override
    public boolean check(List<String> coordinates, List<DeckShip> deckShips, List<Coordinate> shipCoordinate) {
        return false;
    }
}
