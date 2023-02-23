package com.seabattle.usecase.dto;

import com.seabattle.usecase.Result;

public class ResultMove {

    private String coordinate;
    private Result result;

    public ResultMove(String coordinate, Result result) {
        this.coordinate = coordinate;
        this.result = result;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public Result getResult() {
        return result;
    }
}
