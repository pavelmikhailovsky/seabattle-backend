package com.seabattle.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "coordinate")
public class CoordinateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;
    @ManyToOne
    @Column
    private DeckShipEntity ship;

    public CoordinateEntity() {}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public DeckShipEntity getShip() {
        return ship;
    }

    public void setShip(DeckShipEntity ship) {
        this.ship = ship;
    }
}
