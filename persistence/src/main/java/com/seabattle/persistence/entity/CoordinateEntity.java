package com.seabattle.persistence.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "coordinate")
public class CoordinateEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column
    private String content;
    @ManyToOne
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
}
