package com.read_fy.api.controllers;

import com.read_fy.api.dtos.BuscaResponseDTO;
import com.read_fy.api.dtos.LivroResponseDTO;
import com.read_fy.api.dtos.LivroResumoDTO;
import com.read_fy.api.models.Livro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    private final WebClient webClient;

    public LivroController(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping
    public ResponseEntity<List<LivroResumoDTO>> buscar(@RequestParam("title") String titulo) {
        return ResponseEntity.ok(
                webClient.get()
                        .uri("/search.json?title={titulo}", titulo)
                        .retrieve()
                        .bodyToMono(BuscaResponseDTO.class)
                        .map(BuscaResponseDTO::docs)
                        .block()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroResponseDTO> buscarPorId(@PathVariable String id) {
        return ResponseEntity.ok(webClient.get()
            .uri("/books/{id}.json", id)
            .retrieve()
            .bodyToMono(LivroResponseDTO.class)
            .block());
    }
}
