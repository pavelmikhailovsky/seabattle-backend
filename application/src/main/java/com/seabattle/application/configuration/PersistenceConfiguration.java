package com.seabattle.application.configuration;

import com.seabattle.persistence.hibernate.HibernateBeanConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({HibernateBeanConfiguration.class})
public class PersistenceConfiguration {
}
