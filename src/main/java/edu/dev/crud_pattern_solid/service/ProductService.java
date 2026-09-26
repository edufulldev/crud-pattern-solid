package edu.dev.crud_pattern_solid.service;

import edu.dev.crud_pattern_solid.DTOs.ProductRequestDTO;
import edu.dev.crud_pattern_solid.DTOs.ProductResponseDTO;

import java.util.List;

public interface ProductService {

    ProductResponseDTO create(ProductRequestDTO request);
    ProductResponseDTO findById(Long id);
    List<ProductResponseDTO> findAll();
    ProductResponseDTO update(Long id, ProductRequestDTO request);
    void delete(Long id);
}
