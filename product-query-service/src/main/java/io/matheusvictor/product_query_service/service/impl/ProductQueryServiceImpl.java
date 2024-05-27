package io.matheusvictor.product_query_service.service.impl;

import io.matheusvictor.product_query_service.dto.ProductEvent;
import io.matheusvictor.product_query_service.entity.Product;
import io.matheusvictor.product_query_service.repository.ProductRepository;
import io.matheusvictor.product_query_service.service.ProductQueryService;
import org.springframework.kafka.annotation.KafkaListener;
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
        return this.repository.findById(id).get();
    }

    @KafkaListener(topics = "product-event", groupId = "product-event-group")
    private void processProductEvent(ProductEvent product) {
        if (product.getEventType().equals("CreateProduct")) {
            this.repository.save(product.getProduct());
        } else if (product.getEventType().equals("UpdateProduct")) {
            Product productToUpdate = this.repository.findById(product.getProduct().getId()).orElseThrow();
            productToUpdate.setName(product.getProduct().getName());
            productToUpdate.setDescription(product.getProduct().getDescription());
            productToUpdate.setPrice(product.getProduct().getPrice());

            this.repository.save(productToUpdate);
        }
    }
}
