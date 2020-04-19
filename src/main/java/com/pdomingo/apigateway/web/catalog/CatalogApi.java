package com.pdomingo.apigateway.web.catalog;

import com.pdomingo.apigateway.configuration.endpoints.CatalogEndpoints;
import com.pdomingo.apigateway.services.facades.CatalogFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
@RequiredArgsConstructor
public class CatalogApi {

    private final CatalogFacade facade;
    private final CatalogEndpoints endpoints;
}
