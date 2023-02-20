package com.seabattle.entities.dto;

import java.util.Collections;
import java.util.List;

public class DeckShip {

    private List<Coordinate> coordinates;
    private List<Coordinate> damageCoordinates;
    private boolean isSank;

    public DeckShip(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
        this.damageCoordinates = Collections.emptyList();
        this.isSank = false;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public List<Coordinate> getDamageCoordinates() {
        return damageCoordinates;
    }

    public void setDamageCoordinates(List<Coordinate> damageCoordinates) {
        this.damageCoordinates = damageCoordinates;
    }

    public boolean isSank() {
        return isSank;
    }

    public void setSank(boolean sank) {
        isSank = sank;
    }
}
