package com.pdomingo.apigateway.services.facades;

import com.pdomingo.apigateway.web.shoppingcart.model.ShoppingCartComposedView;
import reactor.core.publisher.Mono;

public interface ShoppingCartFacade {
    Mono<ShoppingCartComposedView> fetchShoppingCart(String clientId);
    Mono<ShoppingCartComposedView> addShoppingCartItem(String clientId, String productId);
    Mono<ShoppingCartComposedView> removeShoppingCartItem(String clientId, String productId);
}
