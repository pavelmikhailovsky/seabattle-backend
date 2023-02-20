package com.seabattle.entities.rules.ship_build;

public enum DeckShipType {

    SINGLE_DECK_SHIP(1),
    DOUBLE_DECK_SHIP(2),
    TREE_DECK_SHIP(3),
    FOUR_DECK_SHIP(4);

    private int numberDecks;

    DeckShipType(int numberDecks) {
        this.numberDecks = numberDecks;
    }

    public int getNumberDecks() {
        return numberDecks;
    }
}
