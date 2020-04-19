package com.pdomingo.apigateway.configuration;

import com.pdomingo.apigateway.configuration.endpoints.CatalogEndpoints;
import com.pdomingo.apigateway.configuration.endpoints.ClientEndpoints;
import com.pdomingo.apigateway.configuration.endpoints.ShoppingCartEndpoints;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceEndpointConfiguration {

    private static final String clientServiceURI = "http://localhost:8080";
    private static final String shoppingCartURI = "http://localhost:8081";
    private static final String catalogServiceURI = "http://localhost:8083";

    @Bean
    ClientEndpoints clientEndpoints() {
        return new ClientEndpoints(clientServiceURI);
    }

    @Bean
    ShoppingCartEndpoints shoppingCartEndpoints() {
        return new ShoppingCartEndpoints(shoppingCartURI);
    }

    @Bean
    CatalogEndpoints catalogEndpoints() {
        return new CatalogEndpoints(catalogServiceURI);
    }
}
