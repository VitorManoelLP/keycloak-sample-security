package com.keycloak.example.components;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "spring.security.oauth2.client.registration.keycloak")
public class KeycloakProperties {

    private String clientId;
    private String clientSecret;
    private String scope;
    private String authUri;
    private String realm;

}
