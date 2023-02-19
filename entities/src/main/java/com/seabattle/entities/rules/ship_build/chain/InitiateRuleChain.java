package com.seabattle.entities.rules.ship_build.chain;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.entities.dto.DeckShip;
import com.seabattle.entities.rules.ship_build.CoordinatesAroundFutureShip;
import com.seabattle.entities.rules.ship_build.ShipBuilding;
import com.seabattle.entities.rules.ship_build.exceptions.ShipBuildingException;

import java.util.List;

public class InitiateRuleChain implements ShipBuilding {

    @Override
    public boolean canBuild(List<String> coordinates, List<DeckShip> deckShips, List<Coordinate> shipCoordinate) throws ShipBuildingException {
        ShipBuildingRuleChain chain = ShipBuildingRuleChain.link(
                new ShipIntegrityRuleChain(),
                new NumberShipsRuleChain(),
                new ShipCrossingRuleChain(),
                new DistanceBetweenShipsRuleChain(new CoordinatesAroundFutureShip(coordinates)));

        return chain.check(coordinates, deckShips, shipCoordinate);
    }
}
