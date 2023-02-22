package com.seabattle.usecase.scenarios;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.usecase.YourMove;
import com.seabattle.usecase.access.CoordinateExtractor;
import com.seabattle.usecase.exceptions.YourMoveUseCaseException;

import java.util.List;

public class YourMoveUseCase implements YourMove {

    private CoordinateExtractor coordinateExtractor;

    public YourMoveUseCase(CoordinateExtractor coordinateExtractor) {
        this.coordinateExtractor = coordinateExtractor;
    }

    @Override
    public String execute(String coordinate) throws YourMoveUseCaseException {
        List<Coordinate> yourMoveCoordinates = coordinateExtractor.getAll();

        for (Coordinate yourMoveCoordinate : yourMoveCoordinates) {

            if (coordinate.equals(yourMoveCoordinate.getContent())) {
                throw new YourMoveUseCaseException("You have already used this coordinate");
            }

        }
        return coordinate;
    }
}
