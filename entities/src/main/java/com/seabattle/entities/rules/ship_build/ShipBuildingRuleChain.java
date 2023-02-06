package com.seabattle.entities.rules.ship_build;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.entities.dto.DeckShip;
import com.seabattle.entities.rules.ship_build.exceptions.ShipBuildingException;

import java.util.List;

abstract public class ShipBuildingRuleChain {

    protected final int BOARD_MAX_INTEGER = 10;
    protected final int BOARD_MIN_INTEGER = 1;
    protected final int TOP_LETTER_BOARD_ASCII = 65;
    protected final int BOTTOM_LETTER_BOARD_ASCII = 74;

    private ShipBuildingRuleChain next;

    public static ShipBuildingRuleChain link(ShipBuildingRuleChain firstRule, ShipBuildingRuleChain... chain) {
        ShipBuildingRuleChain head = firstRule;
         for (ShipBuildingRuleChain rule: chain) {
             head.next = rule;
             head = rule;
         }
         return firstRule;
    }

    public abstract boolean check(List<String> coordinates, List<DeckShip> deckShips, List<Coordinate> shipCoordinate) throws ShipBuildingException;

    protected boolean checkNext(List<String> coordinates, List<DeckShip> deckShips, List<Coordinate> shipCoordinate) throws ShipBuildingException {
        if (next == null) {
            return true;
        }
        return next.check(coordinates, deckShips, shipCoordinate);
    }

}
