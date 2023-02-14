package com.seabattle.entities.rules.ship_build;

public enum Board {

    MARKUP_MAX_INTEGER(10),
    MARKUP_MIN_INTEGER(1),
    MARKUP_TOP_LETTER_ASCII(65),
    MARKUP_BOTTOM_LETTER_ASCII(74),

    NUMBER_SINGLE_DECK_SHIP(4),
    NUMBER_DOUBLE_DECK_SHIP(3),
    NUMBER_TREE_DECK_SHIP(2),
    NUMBER_FOUR_DECK_SHIP(1);

    private int i;

    Board(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }
}
