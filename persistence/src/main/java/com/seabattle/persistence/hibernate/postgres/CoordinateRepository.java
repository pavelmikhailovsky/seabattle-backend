package com.seabattle.persistence.hibernate.postgres;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.persistence.entity.CoordinateEntity;
import com.seabattle.usecase.access.CoordinateExtractor;
import com.seabattle.usecase.access.CoordinatePersistence;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CoordinateRepository implements CoordinateExtractor, CoordinatePersistence {

    private CriteriaBuilder criteriaBuilder;
    private CriteriaQuery<CoordinateEntity> criteriaQuery;
    private List<CoordinateEntity> coordinateEntities;
    private List<Coordinate> coordinates = new ArrayList<>();

    @Override
    public List<Coordinate> getAll() {

        try(Session session = HibernateSettings.getSessionFactory().openSession()) {
            criteriaBuilder = session.getCriteriaBuilder();
            criteriaQuery = criteriaBuilder.createQuery(CoordinateEntity.class);
            Root<CoordinateEntity> root = criteriaQuery.from(CoordinateEntity.class);

            criteriaQuery.select(root).where(criteriaBuilder.notEqual(root.get("ship"), null));
            coordinateEntities = session.createQuery(criteriaQuery).getResultList();

            for (CoordinateEntity c : coordinateEntities) {
                coordinates.add(c.getCoordinate());
            }
        }

        return coordinates;
    }

    @Override
    public List<Coordinate> getAllMoves() {

        try(Session session = HibernateSettings.getSessionFactory().openSession()) {
            criteriaBuilder = session.getCriteriaBuilder();
            criteriaQuery = criteriaBuilder.createQuery(CoordinateEntity.class);
            Root<CoordinateEntity> root = criteriaQuery.from(CoordinateEntity.class);

            criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("ship"), null));
            coordinateEntities = session.createQuery(criteriaQuery).getResultList();

            for (CoordinateEntity c : coordinateEntities) {
                coordinates.add(c.getCoordinate());
            }
        }

        return coordinates;
    }

    @Override
    public String save(String coordinate) {
        return null;
    }
}
