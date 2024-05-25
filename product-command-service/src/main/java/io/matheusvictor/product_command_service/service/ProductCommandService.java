package io.matheusvictor.product_command_service.service;

import io.matheusvictor.product_command_service.entity.Product;

public interface ProductCommandService {

    Product create(Product product);

    Product update(Long id, Product product);

    void delete(Long id);
}
