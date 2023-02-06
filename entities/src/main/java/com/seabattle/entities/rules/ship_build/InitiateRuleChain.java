package com.seabattle.entities.rules.build;

import java.util.List;

public class InitiateRuleChain implements ShipBuilding {

    @Override
    public boolean canBuild(List<String> coordinates, List<DeckShip> deckShips, List<Coordinate> shipCoordinate) {
        ShipBuildingRuleChain chain = ShipBuildingRuleChain.link(
                new ShipIntegrityRuleChain(),
                new NumberShipsRuleChain(),
                new ShipCrossingRuleChain(),
                new DistanceBetweenShipsRuleChain());

        return chain.check(coordinates, deckShips, shipCoordinate);
    }
}
