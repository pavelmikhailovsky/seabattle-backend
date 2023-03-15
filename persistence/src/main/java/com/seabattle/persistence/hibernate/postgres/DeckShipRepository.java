package com.seabattle.persistence.hibernate.postgres;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.entities.dto.DeckShip;
import com.seabattle.persistence.entity.CoordinateEntity;
import com.seabattle.persistence.entity.DeckShipEntity;
import com.seabattle.usecase.access.DeckShipExtractor;
import com.seabattle.usecase.access.DeckShipPersistence;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.UUID;

public class DeckShipRepository implements DeckShipPersistence, DeckShipExtractor {

    private CriteriaBuilder criteriaBuilder;
    private CriteriaQuery<DeckShipEntity> criteriaQuery;
    private Root<DeckShipEntity> root;
    private Transaction transaction;
    private DeckShip deckShip;
    private UUID uuid;

    @Override
    public List<DeckShip> getAll() {
        try(Session session = HibernateSettings.getSessionFactory().openSession()) {
            criteriaBuilder = session.getCriteriaBuilder();
            criteriaQuery = criteriaBuilder.createQuery(DeckShipEntity.class);
            root = criteriaQuery.from(DeckShipEntity.class);

            criteriaQuery.select(root);

            List<DeckShipEntity> deckShipEntities = session.createQuery(criteriaQuery).getResultList();
            List<DeckShip> deckShips = new java.util.ArrayList<>();

            for (DeckShipEntity d : deckShipEntities) {
                deckShips.add(d.getDeckShip());
            }

            return deckShips;
        }
    }

    @Override
    public DeckShip save(List<Coordinate> coordinates) {
        try(Session session = HibernateSettings.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            DeckShipEntity deckShipEntity = new DeckShipEntity();

            for (Coordinate coordinate : coordinates) {
                deckShipEntity.addCoordinate(new CoordinateEntity(coordinate.getContent()));
            }

           uuid = (UUID) session.save(deckShipEntity);

            transaction.commit();

            deckShip = new DeckShip(uuid, coordinates);

        } catch (Exception e) {
            transaction.rollback();
        }

        return deckShip;
    }

    @Override
    public void update(DeckShip deckShip) {

    }
}
