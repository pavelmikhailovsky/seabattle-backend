package com.seabattle.entities.rules.ship_build;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HorizontalSequenceTest {

    HorizontalSequence horizontalSequence;

    @BeforeEach
    void setup() {
        horizontalSequence = new HorizontalSequence();
    }

    @Test
    void willReturnFalseIfLetterNotMatch() {
        String currentCoordinate = "A8";
        String pastCoordinate = "B9";
        int iterationNumber = 1;

        assertFalse(horizontalSequence.check(currentCoordinate, pastCoordinate, iterationNumber));
    }

    @Test
    void willReturnFalseIfSequenceEqualVertical() {
        String currentCoordinate = "C5";
        String pastCoordinate = "B5";
        int iterationNumber = 1;

        assertFalse(horizontalSequence.check(currentCoordinate, pastCoordinate, iterationNumber));
    }

    @Test
    void willTrueIfHorizontalSequenceFromRightLeft() {
        String currentCoordinate = "C4";
        String pastCoordinate = "C5";
        int iterationNumber = 1;

        assertTrue(horizontalSequence.check(currentCoordinate, pastCoordinate, iterationNumber));
    }

    @Test
    void willFalseIfHorizontalSequenceFromRightLeftWasNotOnFirstIteration() {
        String currentCoordinate = "C3";
        String pastCoordinate = "C4";
        int iterationNumber = 2;

        assertFalse(horizontalSequence.check(currentCoordinate, pastCoordinate, iterationNumber));
    }

}
