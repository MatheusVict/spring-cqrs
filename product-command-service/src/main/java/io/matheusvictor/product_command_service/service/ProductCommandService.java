package io.matheusvictor.product_command_service.service;

import io.matheusvictor.product_command_service.dto.ProductEvent;
import io.matheusvictor.product_command_service.entity.Product;

public interface ProductCommandService {

    Product create(ProductEvent product);

    Product update(Long id, ProductEvent product);

    void delete(Long id);
}
