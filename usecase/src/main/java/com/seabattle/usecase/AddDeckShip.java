package com.seabattle.usecase;

import com.seabattle.entities.dto.DeckShip;
import com.seabattle.entities.rules.ship_build.exceptions.DeckShipBuildingException;

import java.util.List;

public interface AddDeckShip {

    DeckShip execute(List<String> coordinates) throws DeckShipBuildingException;
}
