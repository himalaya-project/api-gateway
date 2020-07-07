package com.pdomingo.apigateway.configuration.endpoints;

import java.net.URI;

public class ClientEndpoints extends BaseEndpointBuilder {
    public ClientEndpoints(String clientServiceURI) {
        super(clientServiceURI);
    }

    public URI fetchClient(String clientId) {
        // TODO REVIEW
        return baseEndpoint.cloneBuilder().path("/client/{clientId}").build(clientId);
    }

    public URI registerClient() {
        return baseEndpoint.cloneBuilder().path("/client").build().toUri();
    }

    public URI unregisterClient(String clientId) {
        return baseEndpoint.cloneBuilder().path("/client/{clientId}").build(clientId);
    }
}
