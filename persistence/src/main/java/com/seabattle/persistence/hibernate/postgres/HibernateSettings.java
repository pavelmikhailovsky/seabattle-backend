package com.seabattle.persistence.hibernate.postgres;

import com.seabattle.persistence.entity.CoordinateEntity;
import com.seabattle.persistence.entity.DeckShipEntity;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateSettings {

    private static SessionFactory sessionFactory;
    private static Configuration configuration;

    static {
        configuration = new Configuration();

        configuration.addAnnotatedClass(DeckShipEntity.class);
        configuration.addAnnotatedClass(CoordinateEntity.class);

        Properties settings = new Properties();

        settings.put(Environment.DRIVER, "org.postgresql.Driver");
        settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/seabattle");
        settings.put(Environment.USER, "postgres");
        settings.put(Environment.PASS, "postgres");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");

        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        settings.put(Environment.HBM2DDL_AUTO, "update");

        configuration.setProperties(settings);
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {

            try {
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties())
                        .build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return sessionFactory;
    }
}
