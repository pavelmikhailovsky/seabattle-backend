package com.seabattle.persistence.hibernate.postgres;

import com.seabattle.entities.dto.Coordinate;
import com.seabattle.persistence.entity.CoordinateEntity;
import com.seabattle.usecase.access.CoordinateExtractor;
import com.seabattle.usecase.access.CoordinatePersistence;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.stream.Collectors;

public class CoordinateRepository implements CoordinateExtractor, CoordinatePersistence {

    private CriteriaBuilder criteriaBuilder;
    private CriteriaQuery<CoordinateEntity> criteriaQuery;
    private List<CoordinateEntity> coordinateEntities;

    @Override
    public List<Coordinate> getAll() {

        try(Session session = HibernateSettings.getSessionFactory().openSession()) {
            criteriaBuilder = session.getCriteriaBuilder();
            criteriaQuery = criteriaBuilder.createQuery(CoordinateEntity.class);
            Root<CoordinateEntity> root = criteriaQuery.from(CoordinateEntity.class);

            criteriaQuery.select(root).where(criteriaBuilder.notEqual(root.get("ship"), null));
            coordinateEntities = session.createQuery(criteriaQuery).getResultList();
        }

        return coordinateEntities.stream()
                .map((c) -> new Coordinate(c.getId(), c.getContent()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Coordinate> getAllMoves() {

        try(Session session = HibernateSettings.getSessionFactory().openSession()) {
            criteriaBuilder = session.getCriteriaBuilder();
            criteriaQuery = criteriaBuilder.createQuery(CoordinateEntity.class);
            Root<CoordinateEntity> root = criteriaQuery.from(CoordinateEntity.class);

            criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("ship"), null));
            coordinateEntities = session.createQuery(criteriaQuery).getResultList();
        }

        return coordinateEntities.stream()
                .map((c) -> new Coordinate(c.getId(), c.getContent()))
                .collect(Collectors.toList());
    }

    @Override
    public String save(String coordinate) {
        return null;
    }
}
