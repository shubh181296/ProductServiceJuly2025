package com.ecommerce.productservicejuly2025.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


/*
This is a configuration class in SpringBoot Application.
It is annotated with @configuration, indicating this provides
bean definitions and configuration for the application context
 */
@Configuration
public class ApplicationConfig {

    @Bean //denotes this method is a bean producer
    RestTemplate getrestTemplate() {
        return new RestTemplate();
    }

}

