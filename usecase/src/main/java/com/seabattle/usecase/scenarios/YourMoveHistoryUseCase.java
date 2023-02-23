package com.seabattle.usecase.scenarios;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.usecase.YourMoveHistory;
import com.seabattle.usecase.access.CoordinateExtractor;

import java.util.List;

public class YourMoveHistoryUseCase implements YourMoveHistory {

    private CoordinateExtractor coordinateExtractor;

    public YourMoveHistoryUseCase(CoordinateExtractor coordinateExtractor) {
        this.coordinateExtractor = coordinateExtractor;
    }

    @Override
    public List<Coordinate> execute() {
        return coordinateExtractor.getAllMoves();
    }
}
