package com.seabattle.entities.rules.ship_build.chain;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.entities.dto.DeckShip;
import com.seabattle.entities.rules.ship_build.CoordinatesAroundFutureShip;
import com.seabattle.entities.rules.ship_build.exceptions.DistanceBetweenShipsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


class DistanceBetweenShipsRuleChainTest {

    @Mock
    CoordinatesAroundFutureShip coordinatesAroundFutureShipMock;

    DistanceBetweenShipsRuleChain distanceBetweenShipsRuleChain;
    List<DeckShip> deckShips;
    List<Coordinate> shipCoordinates;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);

        distanceBetweenShipsRuleChain = new DistanceBetweenShipsRuleChain(coordinatesAroundFutureShipMock);
        deckShips = List.of(
                new DeckShip(List.of(new Coordinate("B1"), new Coordinate("B2")), List.of(new Coordinate(""))));
        shipCoordinates = List.of(new Coordinate("B1"), new Coordinate("B2"));
    }

    @Test
    void exceptionWillBeThrownIfDistanceBetweenShipsLessThanEstablished() {
        List<String> coordinates = List.of("A1");
        when(coordinatesAroundFutureShipMock.determinate()).thenReturn(Set.of("A2", "B1", "B2"));

        assertThrows(DistanceBetweenShipsException.class, () -> distanceBetweenShipsRuleChain.check(coordinates, deckShips, shipCoordinates));
    }

}
