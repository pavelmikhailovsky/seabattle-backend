package com.seabattle.usecase.access;

import com.seabattle.entities.dto.Coordinate;

public interface CoordinatePersistence {

    String save(Coordinate coordinate);
}
