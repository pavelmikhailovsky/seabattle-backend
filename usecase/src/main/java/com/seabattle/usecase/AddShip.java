package com.seabattle.usecase;

import com.seabattle.entities.dto.DeckShip;
import com.seabattle.entities.rules.ship_build.exceptions.ShipBuildingException;

import java.util.List;

public interface AddShip {

    DeckShip execute(List<String> coordinates) throws ShipBuildingException;
}
