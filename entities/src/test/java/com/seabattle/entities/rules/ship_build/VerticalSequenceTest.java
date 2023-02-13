package com.seabattle.entities.rules.ship_build;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VerticalSequenceTest {

    VerticalSequence verticalSequence;

    @BeforeEach
    void setup() {
        verticalSequence = new VerticalSequence();
    }

    @Test
    void willReturnFalseIfIntegersNotMatch() {
        String currentCoordinate = "A8";
        String pastCoordinate = "B9";
        int iterationNumber = 1;

        assertFalse(verticalSequence.check(currentCoordinate, pastCoordinate, iterationNumber));
    }

    @Test
    void willReturnFalseIfVerticalSequenceFromDownUpWasNotOnFirstIteration() {
        String currentCoordinate = "B3";
        String pastCoordinate = "A3";
        int iterationNumber = 2;

        assertFalse(verticalSequence.check(currentCoordinate, pastCoordinate, iterationNumber));
    }

    @Test
    void willReturnTrueIfVertucalSequenceFromUpDown() {
        String currentCoordinate = "B3";
        String pastCoordinate = "A3";
        int iterationNumber = 1;

        assertTrue(verticalSequence.check(currentCoordinate, pastCoordinate, iterationNumber));
    }

}
