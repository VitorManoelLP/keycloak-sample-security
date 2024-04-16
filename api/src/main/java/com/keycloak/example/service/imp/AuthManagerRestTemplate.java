package com.keycloak.example.service.imp;

import com.keycloak.example.components.KeycloakProperties;
import com.keycloak.example.domain.User;
import com.keycloak.example.service.AuthManager;
import com.keycloak.example.utils.HttpEntityAuth;
import com.keycloak.example.utils.HttpParamBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class AuthManagerRestTemplate implements AuthManager {

    private final KeycloakProperties keycloakProperties;
    private final RestTemplate restTemplate;

    @Override
    public ResponseEntity<?> login(User user) {

        final MultiValueMap<String, String> httpParams = HttpParamBuilder.builder(keycloakProperties)
                .withUsername(user.getUsername())
                .withPassword(user.getPassword())
                .withGrantType("password")
                .build();

        final HttpEntity<MultiValueMap<String, String>> request = HttpEntityAuth.newInstance(httpParams);

        try {

            return restTemplate.postForEntity(
                    keycloakProperties.getAuthUri().concat("/protocol/openid-connect/token"),
                    request,
                    String.class
            );

        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> refresh(String refreshToken) {

        final MultiValueMap<String, String> params = HttpParamBuilder.builder(keycloakProperties)
                .withGrantType("refresh_token")
                .withRefreshToken(refreshToken)
                .build();

        final HttpEntity<MultiValueMap<String, String>> request = HttpEntityAuth.newInstance(params);

        try {

            return restTemplate.postForEntity(
                    keycloakProperties.getAuthUri().concat("/protocol/openid-connect/token"),
                    request,
                    String.class
            );

        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
        }
    }

}
