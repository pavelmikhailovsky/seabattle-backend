package com.seabattle.entities.rules.ship_build.chain;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.entities.dto.DeckShip;
import com.seabattle.entities.rules.ship_build.CoordinatesAroundFutureShip;
import com.seabattle.entities.rules.ship_build.DeckShipBuildingRule;
import com.seabattle.entities.rules.ship_build.exceptions.DeckShipBuildingException;

import java.util.List;

public class InitiateRuleChain implements DeckShipBuildingRule {

    @Override
    public boolean canBuild(List<String> coordinates, List<DeckShip> deckShips, List<Coordinate> shipCoordinates) throws DeckShipBuildingException {
        DeckShipBuildingRuleChain chain = DeckShipBuildingRuleChain.link(
                new DeckShipIntegrityRuleChain(),
                new NumberDeckShipsRuleChain(),
                new DeckShipCrossingRuleChain(),
                new DistanceBetweenDeckShipsRuleChain(new CoordinatesAroundFutureShip(coordinates)));

        return chain.check(coordinates, deckShips, shipCoordinates);
    }
}
