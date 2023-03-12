package com.seabattle.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "deck_ship")
public class DeckShipEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
