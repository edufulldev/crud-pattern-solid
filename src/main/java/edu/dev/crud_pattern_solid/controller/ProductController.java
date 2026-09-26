package edu.dev.crud_pattern_solid.controller;

import edu.dev.crud_pattern_solid.DTOs.ProductRequestDTO;
import edu.dev.crud_pattern_solid.DTOs.ProductResponseDTO;
import edu.dev.crud_pattern_solid.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> create(@Valid @RequestBody ProductRequestDTO request) {
        ProductResponseDTO response = productService.create(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> update
            (@PathVariable Long id, @RequestBody ProductRequestDTO request) {
        return ResponseEntity.ok(productService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
