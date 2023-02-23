package com.seabattle.usecase.access;

import com.seabattle.entities.dto.Coordinate;

import java.util.List;

public interface CoordinateExtractor {

    List<Coordinate> getAll();

    List<Coordinate> getAllMoves();

}
