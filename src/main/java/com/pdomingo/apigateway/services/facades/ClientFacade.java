package com.pdomingo.apigateway.services.facades;

import com.pdomingo.apigateway.web.client.model.ClientComposedView;
import com.pdomingo.apigateway.web.client.model.ClientRegistrationRequest;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

public interface ClientFacade {
    Mono<ClientComposedView> fetchClient(String clientId);

    Mono<ResponseEntity<Void>> registerClient(ClientRegistrationRequest order);

    void unregister(String clientId);
}
