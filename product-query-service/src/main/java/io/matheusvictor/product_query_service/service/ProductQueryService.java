package io.matheusvictor.product_query_service.service;

import io.matheusvictor.product_query_service.entity.Product;

import java.util.List;

public interface ProductQueryService {
    List<Product> findAll();

    Product findById(Long id);
}
