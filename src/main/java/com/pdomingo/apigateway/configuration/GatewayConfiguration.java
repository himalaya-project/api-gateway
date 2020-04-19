package com.pdomingo.apigateway.configuration;

import com.fasterxml.jackson.databind.Module;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.zalando.jackson.datatype.money.MoneyModule;

@Configuration
public class GatewayConfiguration {

    @Bean
    WebClient clientWebClient() {
        return WebClient.create();
    }
    Module moneyModule() {
        return new MoneyModule();
    }

}
