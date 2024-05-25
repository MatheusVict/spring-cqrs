package io.matheusvictor.product_query_service.service.impl;

import io.matheusvictor.product_query_service.entity.Product;
import io.matheusvictor.product_query_service.repository.ProductRepository;
import io.matheusvictor.product_query_service.service.ProductQueryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductQueryServiceImpl implements ProductQueryService {

    private final ProductRepository repository;

    public ProductQueryServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return null;
    }
}
