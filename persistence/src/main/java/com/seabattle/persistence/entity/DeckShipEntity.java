package com.seabattle.persistence.entity;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.entities.dto.DeckShip;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity(name = "deck_ship")
public class DeckShipEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private UUID id;

    @OneToMany(mappedBy = "ship", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CoordinateEntity> coordinates = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CoordinateEntity> damageCoordinates = new ArrayList<>();

    @Column(name = "is_sank", columnDefinition = "boolean default false")
    private boolean isSank;

    public DeckShipEntity() {}

    public void addCoordinate(CoordinateEntity coordinateEntity) {
        coordinates.add(coordinateEntity);
        coordinateEntity.setShip(this);
    }

    public void addDamageCoordinate(CoordinateEntity coordinateEntity) {
        coordinates.remove(coordinateEntity);
        damageCoordinates.add(coordinateEntity);
    }

    public UUID getId() {
        return id;
    }

    public boolean getIsSank() {
        return isSank;
    }

    public List<CoordinateEntity> getDamageCoordinates() {
        return damageCoordinates;
    }

    public List<CoordinateEntity> getCoordinates() {
        return coordinates;
    }

    public DeckShip getDeckShip() {
        List<Coordinate> coordinates = getCoordinates().stream()
                .map(CoordinateEntity::getCoordinate)
                .collect(Collectors.toList());

        List<Coordinate> damageCoordinates;

        if (getDamageCoordinates().isEmpty()) damageCoordinates = new ArrayList<>();
        else damageCoordinates = getDamageCoordinates().stream()
                .map(CoordinateEntity::getCoordinate)
                .collect(Collectors.toList());

        return new DeckShip(
                getId(),
                coordinates,
                damageCoordinates,
                getIsSank()
        );
    }
}
