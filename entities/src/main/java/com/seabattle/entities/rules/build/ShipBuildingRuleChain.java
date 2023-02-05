package com.seabattle.entities.rules.build;

import java.util.List;

abstract public class ShipBuildingRuleChain {

    private ShipBuildingRuleChain next;

    public static ShipBuildingRuleChain link(ShipBuildingRuleChain firstRule, ShipBuildingRuleChain... chain) {
        ShipBuildingRuleChain head = firstRule;
         for (ShipBuildingRuleChain rule: chain) {
             head.next = rule;
             head = rule;
         }
         return firstRule;
    }

    public abstract boolean check(List<String> coordinates, List<DeckShip> deckShips, List<Coordinate> shipCoordinate);

    protected boolean checkNext(List<String> coordinates, List<DeckShip> deckShips, List<Coordinate> shipCoordinate) {
        if (next == null) {
            return true;
        }
        return next.check(coordinates, deckShips, shipCoordinate);
    }

}
