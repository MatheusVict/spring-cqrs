package io.matheusvictor.product_command_service.service.impl;

import io.matheusvictor.product_command_service.entity.Product;
import io.matheusvictor.product_command_service.repository.ProductRepository;
import io.matheusvictor.product_command_service.service.ProductCommandService;
import org.springframework.stereotype.Service;

@Service
public class ProductCommandServiceImpl implements ProductCommandService {

    private final ProductRepository repository;

    public ProductCommandServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product create(Product product) {
        return this.repository.save(product);
    }

    @Override
    public Product update(Long id, Product product) {
        Product productToUpdate = this.repository.findById(id).orElseThrow();
        productToUpdate.setName(product.getName());
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setPrice(product.getPrice());

        return this.repository.save(productToUpdate);
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}
