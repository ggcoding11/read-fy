package com.read_fy.api.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LivroResumoDTO(
        String key,
        String title,

        @JsonProperty("author_name")
        List<String> authorName,

        @JsonIgnoreProperties("first_publish_year")
        Integer firstPublisherYear,

        @JsonProperty("cover_i")
        Long coverId
) {
}
