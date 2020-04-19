package com.pdomingo.apigateway.services.implementation.client;

import com.pdomingo.apigateway.services.facades.ClientFacade;
import com.pdomingo.apigateway.services.implementation.ProxyHelper;
import com.pdomingo.apigateway.configuration.endpoints.ClientEndpoints;
import com.pdomingo.apigateway.web.client.model.ClientComposedView;
import com.pdomingo.apigateway.web.client.model.ClientRegistrationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.net.URI;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientFacadeImpl implements ClientFacade {

    private final WebClient webClient;
    private final ClientEndpoints endpoints;

    @Override
    public Mono<ClientComposedView> fetchClient(String clientId) {
        URI uri = endpoints.fetchClient(clientId);
        return ProxyHelper.get(webClient, uri, ClientComposedView.class);
    }

    @Override
    public Mono<ResponseEntity<Void>> registerClient(ClientRegistrationRequest order) {
        Mono<ResponseEntity<Void>> response = webClient.post()
                .uri(endpoints.registerClient())
                .bodyValue(order)
                .retrieve()
                .toBodilessEntity();
        return response;
    }

    @Override
    public void unregister(String clientId) {
        URI uri = endpoints.unregisterClient(clientId);
        ProxyHelper.delete(webClient, uri, String.class);
    }
}
