package com.read_fy.api.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient webClient(){
        return WebClient.builder()
                .baseUrl("https://openlibrary.org/api/books")
                .defaultHeader("Accept","application/json")
                .build();
    }
}
