package edu.dev.crud_pattern_solid.service.impl;

import edu.dev.crud_pattern_solid.DTOs.ProductRequestDTO;
import edu.dev.crud_pattern_solid.DTOs.ProductResponseDTO;
import edu.dev.crud_pattern_solid.domain.Product;
import edu.dev.crud_pattern_solid.mapper.ProductMapper;
import edu.dev.crud_pattern_solid.repository.ProductRepository;
import edu.dev.crud_pattern_solid.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.dev.crud_pattern_solid.exceptions.ResourceNotFoundException;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl  implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductResponseDTO create(ProductRequestDTO request) {
        Product product = productMapper.toEntity(request);
        Product saved = productRepository.save(product);
        return productMapper.toResponseDTO(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductResponseDTO findById(Long id) {
        Product product = findProductOrThrow(id);
        return productMapper.toResponseDTO(product);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponseDTO> findAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toResponseDTO)
                .toList();
    }

    @Override
    public ProductResponseDTO update(Long id, ProductRequestDTO request) {
        Product product = findProductOrThrow(id);
        productMapper.updateEntityFromDTO(product, request);
        Product updated = productRepository.save(product);
        return productMapper.toResponseDTO(updated);
    }

    @Override
    public void delete(Long id) {
        Product product = findProductOrThrow(id);
        productRepository.delete(product);
    }

    private Product findProductOrThrow(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Produto não encontrado com id: " + id));
    }
}
