package com.seabattle.application.configuration;

import com.seabattle.rest.EndpointConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({EndpointConfiguration.class})
public class RestConfiguration {
}
