package com.pdomingo.apigateway.web.client;

import com.pdomingo.apigateway.composition.facades.ClientFacade;
import com.pdomingo.apigateway.web.client.model.ClientComposedView;
import com.pdomingo.apigateway.web.client.model.ClientRegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotEmpty;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientApi {

    public final ClientFacade facade;

    @GetMapping("/{clientId}")
    public Mono<ClientComposedView> fetchClientData(@PathVariable @NotEmpty String clientId) {
        return facade.fetchClient(clientId);
    }

    @PostMapping
    public Mono<ResponseEntity<Void>> registerClient(@RequestBody ClientRegistrationRequest order) {
        return facade.registerClient(order);
    }

    @DeleteMapping("/{clientId}")
    public Mono<ResponseEntity<Object>> unregisterClient(@PathVariable @NotEmpty String clientId) {
        facade.unregister(clientId);
        return Mono.just(ResponseEntity.ok().build());
    }
}
