package com.pdomingo.apigateway.configuration.endpoints;

import org.springframework.web.util.UriComponentsBuilder;

abstract class BaseEndpointBuilder {

    protected final UriComponentsBuilder baseEndpoint;

    protected BaseEndpointBuilder(String baseEndpoint) {
        this.baseEndpoint = UriComponentsBuilder.fromHttpUrl(baseEndpoint);
    }
}
