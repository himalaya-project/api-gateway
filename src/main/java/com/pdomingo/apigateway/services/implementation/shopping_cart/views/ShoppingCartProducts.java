package com.pdomingo.apigateway.services.implementation.shopping_cart.views;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.javamoney.moneta.Money;

import javax.money.MonetaryAmount;
import java.util.Collection;

@Data
@NoArgsConstructor
public class ShoppingCartProducts {

    private Collection<ProductData> products;

    @Data
    @NoArgsConstructor
    public static class ProductData {
        private String productId;
        private String name;
        private String description;
        private String brand;
        private String model;
        private String category;
        private Money retailPrice;
        private long stock;
        private Collection<String> images;
    }
}
