package edu.dev.crud_pattern_solid.DTOs;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record ProductRequestDTO(

        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 2, max = 120, message = "O nome deve ter entre 2 e 120 caracteres")
        String name,

        @Size(max = 500, message = "A descrição deve ter no máximo 500 caracteres")
        String description,

        @NotNull(message = "O preço é obrigatório")
        @DecimalMin(value = "0.01", message = "O preço deve ser maior que zero")
        BigDecimal price,

        @NotNull(message = "O estoque é obrigatório")
        @Min(value = 0, message = "O estoque não pode ser negativo")
        Integer stock

) {
}