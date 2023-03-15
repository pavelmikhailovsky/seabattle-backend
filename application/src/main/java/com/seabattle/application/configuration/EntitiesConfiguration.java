package com.seabattle.application.configuration;

import com.seabattle.entities.rules.ship_build.DeckShipBuildingRule;
import com.seabattle.entities.rules.ship_build.chain.InitiateRuleChain;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EntitiesConfiguration {

    @Bean
    public DeckShipBuildingRule deckShipBuildingRule() {
        return new InitiateRuleChain();
    }

}
