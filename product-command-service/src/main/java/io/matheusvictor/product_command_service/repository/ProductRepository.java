package io.matheusvictor.product_command_service.repository;

import io.matheusvictor.product_command_service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
