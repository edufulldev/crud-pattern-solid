package edu.dev.crud_pattern_solid.DTOs;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductResponseDTO(
        Long id,
        String name,
        String description,
        BigDecimal price,
        Integer stock,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
