package com.seabattle.entities.rules.ship_build;

public enum Board {

    MAX_INTEGER(10),
    MIN_INTEGER(1),
    TOP_LETTER_ASCII(65),
    BOTTOM_LETTER_ASCII(74);

    private int i;

    Board(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }
}
