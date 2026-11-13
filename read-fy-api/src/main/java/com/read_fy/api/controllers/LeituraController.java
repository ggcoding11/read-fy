package com.read_fy.api.controllers;

import com.read_fy.api.dtos.LeituraCreateDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leituras")
public class LeituraController {
    @PostMapping
    public ResponseEntity<String> adicionar(LeituraCreateDto dto) {
        
    }
}
