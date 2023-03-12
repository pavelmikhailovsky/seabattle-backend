package com.seabattle.entities.dto;

import java.util.Objects;

public class Coordinate {

    private final String content;

    public Coordinate(String coordinate) {
        this.content = coordinate;
    }

    public String getContent() {
        return content;
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
