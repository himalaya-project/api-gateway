package com.pdomingo.apigateway.services.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;

@Slf4j
public class ProxyHelper {

    public static <T> Mono<T> get(WebClient webClient, URI uri, Class<T> responseBodyClass) {
        log.info("Proxying GET request to {}", uri);
        return webClient.get().uri(uri).retrieve().bodyToMono(responseBodyClass);
    }

    public static <T> Mono<T> post(WebClient webClient, URI uri, Object body, Class<T> responseBodyClass) {
        log.info("Proxying POST request to {}", uri);
        return webClient.post().uri(uri).bodyValue(body).retrieve().bodyToMono(responseBodyClass);
    }

    public static <T> Mono<T> delete(WebClient webClient, URI uri, Class<T> responseBodyClass) {
        log.info("Proxying DELETE request to {}", uri);
        return webClient.delete().uri(uri).retrieve().bodyToMono(responseBodyClass);
    }
}
