package com.pdomingo.apigateway.configuration.endpoints;

import java.net.URI;

public class CatalogEndpoints extends BaseEndpointBuilder {
    public CatalogEndpoints(String catalogServiceURI) {
        super(catalogServiceURI);
    }

    public URI fetchMultipleProduct() {
        return baseEndpoint.path("/catalog").build().toUri();
    }

    public URI fetchProduct(String productId) {
        return baseEndpoint.path("/catalog/{productId}").build(productId);
    }
}
