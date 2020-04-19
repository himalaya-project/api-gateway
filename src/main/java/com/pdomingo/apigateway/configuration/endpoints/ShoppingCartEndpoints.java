package com.pdomingo.apigateway.configuration.endpoints;

import java.net.URI;

public class ShoppingCartEndpoints extends BaseEndpointBuilder {

    public ShoppingCartEndpoints(String shoppingCartURI) {
        super(shoppingCartURI);
    }

    public URI fetchShoppingCart(String clientId) {
        return baseEndpoint.path("/shopping_cart/{clientId}").build(clientId);
    }

    public URI addShoppingCartItem(String clientId, String productId) {
        return baseEndpoint.path("/shopping_cart/{clientId}/product/{productId}").build(clientId, productId);
    }

    public URI removeShoppingCartItem(String clientId, String productId) {
        return baseEndpoint.path("/shopping_cart/{clientId}/product/{productId}").build(clientId, productId);
    }
}
