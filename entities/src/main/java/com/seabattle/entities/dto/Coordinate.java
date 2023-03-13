package com.seabattle.entities.dto;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Coordinate {

    private UUID id;
    private final String content;

    public Coordinate(String content) {
        this.content = content;
    }

    public Coordinate(UUID id, String coordinate) {
        this.id = id;
        this.content = coordinate;
    }

    public UUID getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public DeckShip getShip() {
        return new DeckShip(UUID.randomUUID(), List.of(new Coordinate("s")));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}
