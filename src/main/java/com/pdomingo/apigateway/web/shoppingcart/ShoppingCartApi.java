package com.pdomingo.apigateway.web.shoppingcart;

import com.pdomingo.apigateway.services.facades.ShoppingCartFacade;
import com.pdomingo.apigateway.web.shoppingcart.model.ShoppingCartComposedView;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotEmpty;

@RestController
@RequestMapping("/client/{clientId}/cart")
@RequiredArgsConstructor
public class ShoppingCartApi {

    public final ShoppingCartFacade facade;

    @GetMapping
    public Mono<ShoppingCartComposedView> fetchShoppingCart(@PathVariable @NotEmpty String clientId) {
        return facade.fetchShoppingCart(clientId);
    }

}
