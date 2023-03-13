package com.seabattle.entities.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DeckShip {

    private UUID id;
    private List<Coordinate> coordinates;
    private List<Coordinate> damageCoordinates;
    private boolean isSank;

    public DeckShip(UUID id, List<Coordinate> coordinates) {
        this.id = id;
        this.coordinates = coordinates;
        this.damageCoordinates = new ArrayList<>();
        this.isSank = false;
    }

    public DeckShip(UUID id, List<Coordinate> coordinates, List<Coordinate> damageCoordinates) {
        this.id = id;
        this.coordinates = coordinates;
        this.damageCoordinates = damageCoordinates;
        this.isSank = false;
    }

    public DeckShip(UUID id, List<Coordinate> coordinates, List<Coordinate> damageCoordinates, boolean isSank) {
        this.id = id;
        this.coordinates = coordinates;
        this.damageCoordinates = damageCoordinates;
        this.isSank = isSank;
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

    public UUID getId() {
        return id;
    }
}
