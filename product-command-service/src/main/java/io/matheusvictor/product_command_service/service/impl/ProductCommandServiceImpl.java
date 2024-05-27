package io.matheusvictor.product_command_service.service.impl;

import io.matheusvictor.product_command_service.dto.ProductEvent;
import io.matheusvictor.product_command_service.entity.Product;
import io.matheusvictor.product_command_service.repository.ProductRepository;
import io.matheusvictor.product_command_service.service.ProductCommandService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductCommandServiceImpl implements ProductCommandService {

    private final ProductRepository repository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public ProductCommandServiceImpl(ProductRepository repository, KafkaTemplate<String, Object> kafkaTemplate) {
        this.repository = repository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public Product create(ProductEvent product) {
        Product productSaved = this.repository.save(product.getProduct());
        this.notifyProductEvent("CreateProduct",productSaved);
        return productSaved;
    }

    @Override
    public Product update(Long id, ProductEvent product) {
        Product productToUpdate = this.repository.findById(id).orElseThrow();
        productToUpdate.setName(productToUpdate.getName());
        productToUpdate.setDescription(productToUpdate.getDescription());
        productToUpdate.setPrice(productToUpdate.getPrice());

        Product productUpdated = this.repository.save(productToUpdate);
        this.notifyProductEvent("UpdateProduct",productUpdated);
        return productUpdated;
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    private void notifyProductEvent(String type, Product product) {
        ProductEvent event = new ProductEvent(type, product);
        kafkaTemplate.send("product-event", event);
    }
}
