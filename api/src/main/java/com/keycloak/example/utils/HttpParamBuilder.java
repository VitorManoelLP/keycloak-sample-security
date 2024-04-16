package com.keycloak.example.utils;

import com.keycloak.example.components.KeycloakProperties;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class HttpParamBuilder {

    private final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

    public static HttpParamBuilder builder(KeycloakProperties properties) {
        final HttpParamBuilder httpParamBuilder = new HttpParamBuilder();
        httpParamBuilder.params.add("client_id", properties.getClientId());
        httpParamBuilder.params.add("client_secret", properties.getClientSecret());
        return httpParamBuilder;
    }

    public HttpParamBuilder withGrantType(String grantType) {
        params.add("grant_type", grantType);
        return this;
    }

    public HttpParamBuilder withUsername(String username) {
        params.add("username", username);
        return this;
    }

    public HttpParamBuilder withPassword(String password) {
        params.add("password", password);
        return this;
    }

    public HttpParamBuilder withRefreshToken(String refreshToken) {
        params.add("refresh_token", refreshToken);
        return this;
    }

    public MultiValueMap<String, String> build() {
        return params;
    }

}
