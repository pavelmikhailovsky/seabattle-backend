package com.seabattle.entities.dto;

public class Coordinate {

    private final String content;
    private final DeckShip shipLink;

    public Coordinate(String coordinate) {
        this.content = coordinate;
        this.shipLink = null;
    }

    public Coordinate(String coordinate, DeckShip ship) {
        this.content = coordinate;
        this.shipLink = ship;
    }

    public String getContent() {
        return content;
    }

    public DeckShip getShipLink() {
        return shipLink;
    }
}
