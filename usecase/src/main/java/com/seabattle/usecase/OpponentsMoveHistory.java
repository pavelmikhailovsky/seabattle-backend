package com.seabattle.usecase;

import com.seabattle.entities.dto.Coordinate;

import java.util.List;

public interface OpponentsMoveHistory {

    List<Coordinate> execute();
}
