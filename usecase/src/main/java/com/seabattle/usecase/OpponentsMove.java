package com.seabattle.usecase;

import com.seabattle.usecase.dto.ResultMove;

public interface OpponentsMove {

    ResultMove execute(String coordinate);
}
