package com.read_fy.api.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LivroResponseDTO(String title, String subtitle, Long number_of_pages) {
}
