package ru.ogneva.library;

import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.springframework.context.annotation.Bean;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;

@KeycloakConfiguration
public class KeycloakConfig {
    @Bean
    public KeycloakSpringBootConfigResolver keycloakConfigResolver() {
        return new KeycloakSpringBootConfigResolver();
    }
}
