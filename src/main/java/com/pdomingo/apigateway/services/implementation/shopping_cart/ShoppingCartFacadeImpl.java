package com.pdomingo.apigateway.services.implementation.shopping_cart;

import com.pdomingo.apigateway.configuration.endpoints.CatalogEndpoints;
import com.pdomingo.apigateway.configuration.endpoints.ShoppingCartEndpoints;
import com.pdomingo.apigateway.services.facades.ShoppingCartFacade;
import com.pdomingo.apigateway.services.implementation.ProxyHelper;
import com.pdomingo.apigateway.services.implementation.shopping_cart.views.ShoppingCardIds;
import com.pdomingo.apigateway.services.implementation.shopping_cart.views.ShoppingCartProducts;
import com.pdomingo.apigateway.web.shoppingcart.model.ShoppingCartComposedView;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class ShoppingCartFacadeImpl implements ShoppingCartFacade {

    private final WebClient webClient;
    private final ShoppingCartEndpoints shoppingCartEndpoints;
    private final CatalogEndpoints catalogEndpoints;

    @Override
    public Mono<ShoppingCartComposedView> fetchShoppingCart(String clientId) {
        URI uri = shoppingCartEndpoints.fetchShoppingCart(clientId);
        Mono<ShoppingCardIds> shoppingCartData = ProxyHelper.get(webClient, uri, ShoppingCardIds.class);

        return shoppingCartData
                .flatMap(this::computeShoppingCartPrice)
                .flatMap(products -> composeView(clientId, products));
    }

    @Override
    public Mono<ShoppingCartComposedView> addShoppingCartItem(String clientId, String productId) {
        Mono<ShoppingCardIds> shoppingCardData = webClient.put()
                .uri(shoppingCartEndpoints.addShoppingCartItem(clientId, productId))
                .retrieve()
                .bodyToMono(ShoppingCardIds.class);

        return shoppingCardData
                .flatMap(this::computeShoppingCartPrice)
                .flatMap(products -> composeView(clientId, products));
    }

    @Override
    public Mono<ShoppingCartComposedView> removeShoppingCartItem(String clientId, String productId) {
        Mono<ShoppingCardIds> shoppingCardData = webClient.put()
                .uri(shoppingCartEndpoints.removeShoppingCartItem(clientId, productId))
                .retrieve()
                .bodyToMono(ShoppingCardIds.class);

        return shoppingCardData
                .flatMap(this::computeShoppingCartPrice)
                .flatMap(products -> composeView(clientId, products));
    }

    /*--------------------------------------------------------------------------------------------*/

    private Mono<ShoppingCartProducts> computeShoppingCartPrice(ShoppingCardIds shoppingCardIds) {
        var body = Map.of("productIds", shoppingCardIds.getProductIds());
        var pricingUri = catalogEndpoints.fetchMultipleProduct();
        return ProxyHelper.post(webClient, pricingUri, body, ShoppingCartProducts.class)
                .onErrorStop();
    }

    private Mono<ShoppingCartComposedView> composeView(String clientId, ShoppingCartProducts products) {
        return Mono.justOrEmpty(new ShoppingCartComposedView(clientId, products));
    }
}
