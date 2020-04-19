package com.pdomingo.apigateway.web.client.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ClientComposedView {
        String alias;
        String fullName;
        String email;
        String phoneNumber;
        String shippingAddress;
        String status;
}