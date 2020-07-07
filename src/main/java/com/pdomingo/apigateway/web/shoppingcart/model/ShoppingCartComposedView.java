package com.pdomingo.apigateway.web.shoppingcart.model;

import com.pdomingo.apigateway.services.implementation.shopping_cart.views.ShoppingCartProducts;
import org.javamoney.moneta.Money;

import javax.money.MonetaryAmount;
import java.util.Collection;

public class ShoppingCartComposedView {

    private String clientId;
    private Collection<ShoppingCartProducts.ProductData> products;
    private MonetaryAmount subtotal;


    public ShoppingCartComposedView(
            String clientId,
            ShoppingCartProducts shoppingCartProducts
    ) {
        this.clientId = clientId;
        this.products = shoppingCartProducts.getProducts();
        this.subtotal = computeSubtotal(shoppingCartProducts);
    }

    private MonetaryAmount computeSubtotal(ShoppingCartProducts shoppingCartProducts) {
        var products = shoppingCartProducts.getProducts();
        return products.stream()
                .map(ShoppingCartProducts.ProductData::getRetailPrice)
                .reduce(Money.of(0, "EUR"), Money::add);
    }
}
