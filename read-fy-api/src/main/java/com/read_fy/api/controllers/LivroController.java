package com.read_fy.api.controllers;

import com.read_fy.api.models.Livro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/livros")
public class LivroController {
    private final WebClient webClient;

    public LivroController(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping("/id")
    public ResponseEntity<String> buscarPorId(@PathVariable Long id) {
        System.out.println(id);

        return ResponseEntity.ok(webClient.get()
                .uri("?bibkeys=ISBN:" + id + "&format=json&jscmd=data")
                .retrieve()
                .bodyToMono(String.class)
                .block());
    }
}
