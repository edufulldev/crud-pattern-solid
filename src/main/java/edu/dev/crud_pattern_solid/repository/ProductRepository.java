package edu.dev.crud_pattern_solid.repository;

import edu.dev.crud_pattern_solid.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
