package com.pdomingo.apigateway.services.implementation.shopping_cart.views;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
public class ShoppingCardIds {
    private Collection<String> productIds;

    public ShoppingCardIds(Collection<String> productIds) {
        this.productIds = productIds;
    }

    public Collection<String> getProductIds() {
        return productIds;
    }
}
