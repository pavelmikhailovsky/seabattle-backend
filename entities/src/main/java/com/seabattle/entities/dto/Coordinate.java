package com.seabattle.entities.dto;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return Objects.equals(content, that.content) && Objects.equals(shipLink, that.shipLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, shipLink);
    }
}
