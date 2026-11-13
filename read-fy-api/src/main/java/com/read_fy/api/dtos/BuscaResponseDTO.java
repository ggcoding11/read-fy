package com.read_fy.api.dtos;

import java.util.List;

public record BuscaResponseDTO(Integer numFound, Integer start, List<LivroResumoDTO> docs) {
}
