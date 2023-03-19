package com.seabattle.persistence.entity;

import com.seabattle.entities.dto.Coordinate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "coordinate")
public class CoordinateEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(updatable = false, nullable = false)
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    private DeckShipEntity ship;

    protected CoordinateEntity() {}

    public CoordinateEntity(String content) {
        this.content = content;
    }

    public UUID getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public DeckShipEntity getShip() {
        return ship;
    }

    public void setShip(DeckShipEntity ship) {
        this.ship = ship;
    }

    public Coordinate getCoordinate() {
        return new Coordinate(getId(), getContent());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoordinateEntity that = (CoordinateEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(content, that.content) && Objects.equals(ship, that.ship);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, ship);
    }
}
