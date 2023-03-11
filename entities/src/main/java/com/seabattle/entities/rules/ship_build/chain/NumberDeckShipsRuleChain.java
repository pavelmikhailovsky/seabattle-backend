package com.seabattle.entities.rules.ship_build.chain;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.entities.dto.DeckShip;
import com.seabattle.entities.rules.ship_build.Board;
import com.seabattle.entities.rules.ship_build.DeckShipType;
import com.seabattle.entities.rules.ship_build.exceptions.NumberDeckShipsException;
import com.seabattle.entities.rules.ship_build.exceptions.DeckShipBuildingException;

import java.util.List;

public class NumberDeckShipsRuleChain extends DeckShipBuildingRuleChain {

    private int currentNumberShipDecks;
    private int allowedNumberShips;

    @Override
    public boolean check(List<String> coordinates, List<DeckShip> deckShips, List<Coordinate> shipCoordinate) throws DeckShipBuildingException {
        currentNumberShipDecks = coordinates.size();
        checkNumberShipDecks(currentNumberShipDecks);
        settingAllowedNumberShipsByDeckType(currentNumberShipDecks);

        if (!deckShips.isEmpty()) {

            int currentNumberShipsCertainDeck = 0;
            for (DeckShip deckShip : deckShips) {
                List<Coordinate> shipCoordinates = deckShip.getCoordinates();

                if (currentNumberShipDecks == shipCoordinates.size()) {
                    currentNumberShipsCertainDeck++;
                    checkNumberShipsCertainDeck(currentNumberShipsCertainDeck);
                }

            }

        }

        return checkNext(coordinates, deckShips, shipCoordinate);
    }

    private void checkNumberShipDecks(int currentDeckShip) throws NumberDeckShipsException {
        if (currentDeckShip > 4) {
            String messageException = String.format(
                    "Number of ship decks exceeded, must be no more than 4, current ship decks: \"%s\"", currentDeckShip
            );

            throw new NumberDeckShipsException(messageException);
        }
    }

    private void checkNumberShipsCertainDeck(int currentNumberShipsCertainDeck) throws NumberDeckShipsException {
        if (allowedNumberShips == currentNumberShipsCertainDeck) {
            String messageException = "It is not possible add this ship, the allowed number of ships of this type has been exceeded";
            throw new NumberDeckShipsException(messageException);
        }
    }

    private void settingAllowedNumberShipsByDeckType(int currentNumberShipDecks) {

        if (currentNumberShipDecks == DeckShipType.SINGLE_DECK_SHIP.getNumberDecks()) {
            allowedNumberShips = Board.NUMBER_SINGLE_DECK_SHIP.getI();
        } else if (currentNumberShipDecks == DeckShipType.DOUBLE_DECK_SHIP.getNumberDecks()) {
            allowedNumberShips = Board.NUMBER_DOUBLE_DECK_SHIP.getI();
        } else if (currentNumberShipDecks == DeckShipType.TREE_DECK_SHIP.getNumberDecks()) {
            allowedNumberShips = Board.NUMBER_TREE_DECK_SHIP.getI();
        } else if (currentNumberShipDecks == DeckShipType.FOUR_DECK_SHIP.getNumberDecks()) {
            allowedNumberShips = Board.NUMBER_FOUR_DECK_SHIP.getI();
        }

    }
}
