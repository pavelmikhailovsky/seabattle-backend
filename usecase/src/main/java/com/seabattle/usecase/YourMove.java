package com.seabattle.usecase;

import com.seabattle.usecase.exceptions.YourMoveUseCaseException;

import java.util.List;

public interface YourMove {

    String execute(String coordinate) throws YourMoveUseCaseException;
}
