package edu.dev.crud_pattern_solid.mapper;

import edu.dev.crud_pattern_solid.DTOs.ProductRequestDTO;
import edu.dev.crud_pattern_solid.DTOs.ProductResponseDTO;
import edu.dev.crud_pattern_solid.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequestDTO dto) {
        return new Product(
                dto.name(),
                dto.description(),
                dto.price(),
                dto.stock()
        );
    }

    public ProductResponseDTO toResponseDTO(Product product) {
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                product.getCreatedAt(),
                product.getUpdatedAt()
        );
    }

    public void updateEntityFromDTO(Product product, ProductRequestDTO dto) {
        product.setName(dto.name());
        product.setDescription(dto.description());
        product.setPrice(dto.price());
        product.setStock(dto.stock());
    }
}
