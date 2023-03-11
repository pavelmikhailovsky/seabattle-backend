package com.seabattle.entities.rules.ship_build.chain;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.entities.dto.DeckShip;
import com.seabattle.entities.rules.ship_build.exceptions.DeckShipBuildingException;

import java.util.List;

abstract public class DeckShipBuildingRuleChain {

    private DeckShipBuildingRuleChain next;

    public static DeckShipBuildingRuleChain link(DeckShipBuildingRuleChain firstRule, DeckShipBuildingRuleChain... chain) {
        DeckShipBuildingRuleChain head = firstRule;
         for (DeckShipBuildingRuleChain rule: chain) {
             head.next = rule;
             head = rule;
         }
         return firstRule;
    }

    public abstract boolean check(List<String> coordinates, List<DeckShip> deckShips, List<Coordinate> shipCoordinates) throws DeckShipBuildingException;

    protected boolean checkNext(List<String> coordinates, List<DeckShip> deckShips, List<Coordinate> shipCoordinates) throws DeckShipBuildingException {
        if (next == null) {
            return true;
        }
        return next.check(coordinates, deckShips, shipCoordinates);
    }

}
