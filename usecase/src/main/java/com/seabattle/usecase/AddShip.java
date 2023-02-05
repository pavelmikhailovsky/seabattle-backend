package com.seabattle.usecase;

import java.util.List;

public interface AddShip {

    DeckShip execute(List<String> coordinates);
}
