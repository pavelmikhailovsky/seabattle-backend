package com.seabattle.persistence.hibernate.postgres;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.usecase.access.CoordinateExtractor;
import com.seabattle.usecase.access.CoordinatePersistence;

import java.util.List;

public class CoordinateRepository implements CoordinateExtractor, CoordinatePersistence {
    @Override
    public List<Coordinate> getAll() {
        return null;
    }

    @Override
    public List<Coordinate> getAllMoves() {
        return null;
    }

    @Override
    public String save(Coordinate coordinate) {
        return null;
    }
}
