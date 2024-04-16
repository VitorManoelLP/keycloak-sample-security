package com.keycloak.example.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;

public class HttpEntityAuth {

    public static HttpEntity<MultiValueMap<String, String>> newInstance(MultiValueMap<String, String> defaultHeader) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return new HttpEntity<>(defaultHeader, httpHeaders);
    }

}
