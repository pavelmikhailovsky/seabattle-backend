package com.seabattle.entities.rules.ship_build.chain;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.entities.dto.DeckShip;
import com.seabattle.entities.rules.ship_build.HorizontalSequence;
import com.seabattle.entities.rules.ship_build.Sequence;
import com.seabattle.entities.rules.ship_build.VerticalSequence;
import com.seabattle.entities.rules.ship_build.exceptions.DeckShipBuildingException;
import com.seabattle.entities.rules.ship_build.exceptions.DeckShipIntegrityException;

import java.util.List;

public class DeckShipIntegrityRuleChain extends DeckShipBuildingRuleChain {

    private final Sequence horizontalSequence;
    private final Sequence verticalSequence;

    private String pastCoordinate;
    private String currentCoordinate;
    private boolean isHorizontalOrder = true;
    private boolean isVerticalOrder = true;

    public DeckShipIntegrityRuleChain() {
        this.horizontalSequence = new HorizontalSequence();
        this.verticalSequence = new VerticalSequence();
    }

    @Override
    public boolean check(List<String> coordinates,
                         List<DeckShip> deckShips,
                         List<Coordinate> shipCoordinates) throws DeckShipBuildingException {

        pastCoordinate = coordinates.stream().findFirst().get();

        for (int i = 1; i <= coordinates.size() - 1; i++) {
            currentCoordinate = coordinates.get(i);

            if (isHorizontalOrder) {
                isHorizontalOrder = horizontalSequence.check(currentCoordinate, pastCoordinate, i);
                pastCoordinate = currentCoordinate;

                if (!isHorizontalOrder) {
                    i = 0;
                    pastCoordinate = coordinates.stream().findFirst().get();
                }

                continue;
            }

            if (!isHorizontalOrder && !isVerticalOrder) {
                throw new DeckShipIntegrityException("The ship must be positioned vertically or horizontally");
            }

            isVerticalOrder = verticalSequence.check(currentCoordinate, pastCoordinate, i);
            pastCoordinate = currentCoordinate;
        }

        return checkNext(coordinates, deckShips, shipCoordinates);
    }

}
